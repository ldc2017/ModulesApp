package com.ldc.app_base.config;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.config
 * 作者: liudi
 * 创建时间: 2020/10/10
 */
public final class ModuleConfig {
    private static final String MAIN_APPLICATION = "com.ldc.app_main.MainAppInit";
    public static String[] modulesInits  = {
            MAIN_APPLICATION,
    };
    //autoSize
    public static final float getSizeInDp = 667;
    public static final boolean isBaseOnWidth = false;
}
