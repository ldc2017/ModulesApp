package com.ldc.app_base.init;

import android.app.Application;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.init
 * 作者: liudi
 * 创建时间: 2020/10/14
 */
public interface BaseAppInit {
    /**
     * @param app
     * @return
     */
    boolean init(Application app);
}
