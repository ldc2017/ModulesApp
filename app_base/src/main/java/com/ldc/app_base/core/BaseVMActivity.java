package com.ldc.app_base.core;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.core
 * 作者: liudi
 * 创建时间: 2020/10/11
 */
public abstract class BaseVMActivity<VM extends BaseViewModel, VB extends ViewBinding> extends BaseVBActivity<VB> {
    protected VM viewModel;


    @Override
    protected void initView() {
        viewModel = initViewModel();
        super.initView();
    }


    protected abstract VM initViewModel();

    //创建ViewModel
    protected VM createViewModel(Application application, Class<VM> tClass) {
        return ViewModelProvider.AndroidViewModelFactory
                .getInstance(application)
                .create(tClass);
    }
}
