package com.ldc.app_base.config;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.config
 * 作者: liudi
 * 创建时间: 2020/10/10
 */
public final class ModuleAppInit {
    private static final String MAIN_APPLICATION = "com.ldc.app_main.AppInit";
    private static final String BLUETOOTH_APPLICATION = "com.ldc.app_bluetooth.AppInit";
    public static String[] modulesInit = {
            MAIN_APPLICATION,
            BLUETOOTH_APPLICATION,
    };
    //autoSize
    public static final float getSizeInDp = 667;
    public static final boolean isBaseOnWidth = false;
}
