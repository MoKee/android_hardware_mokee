LOCAL_PATH := $(call my-dir)

ifeq ($(BOARD_USES_MOKEE_HARDWARE),true)
    include $(call all-makefiles-under,$(LOCAL_PATH))
endif
