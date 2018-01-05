/*
 * Copyright (C) 2017 The MoKee Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mokee.hardware;

import org.mokee.internal.util.FileUtils;

import android.util.Log;

public class ChargerHW {

    private static final String TAG = "ChargerHW";

    private static final String CURRENT_NOW_PATH = "/sys/class/power_supply/usb/input_current_now";
    private static final String VOLTAGE_NOW_PATH = "/sys/class/power_supply/usb/voltage_now";

    public static boolean isSupported() {
        return FileUtils.isFileReadable(CURRENT_NOW_PATH) &&
                FileUtils.isFileReadable(VOLTAGE_NOW_PATH);
    }

    /**
     * Get realtime current
     * @return Current in micro-amps (µA)
     */
    public static int getCurrent() {
        try {
            return Integer.parseInt(FileUtils.readOneLine(CURRENT_NOW_PATH));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return -1;
    }

    /**
     * Get realtime voltage
     * @return Voltage in milli-volts (mV)
     */
    public static int getVoltage() {
        try {
            return Integer.parseInt(FileUtils.readOneLine(VOLTAGE_NOW_PATH));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return -1;
    }
}
