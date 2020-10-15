package com.ldc.app_base.core;

import androidx.lifecycle.ViewModel;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.core
 * 作者: liudi
 * 创建时间: 2020/10/11
 */
public abstract class BaseViewModel extends ViewModel {
    public BaseViewModel() {
        init();
    }

    protected abstract void init();
}
