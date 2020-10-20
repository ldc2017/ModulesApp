package com.ldc.app_base;

import android.app.Application;

import com.ldc.app_base.config.ModuleAppInit;

/**
 * 项目: ModulesApp
 * 包名: com.ldc.app_base
 * 作者: liudi
 * 创建时间: 2020/10/20
 */
public class CommonApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }


    protected void init(Application app) {
    }

    //高优先级
    protected void moduleAppInit() {
        try {
            for (String init : ModuleAppInit.modulesInit) {
                Class<?> clazz = Class.forName(init);
                CommonApplication baseAppInit = (CommonApplication) clazz.newInstance();
                baseAppInit.init(this);
                System.err.println(String.format("---- %s ---", clazz.getName()));
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.err.println(String.format("%s", e.getLocalizedMessage()));
        }
    }
}
