package com.ldc.app_main;

import android.app.Application;

import com.ldc.app_base.init.BaseAppInit;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_main
 * 作者: liudi
 * 创建时间: 2020/10/10
 */
public class MainAppInit implements BaseAppInit {
    private static Application application;

    public static Application getApplication() {
        return application;
    }


    /**
     * @param app
     * @return
     */
    @Override
    public boolean init(Application app) {
        application = app;
        return false;
    }
}
