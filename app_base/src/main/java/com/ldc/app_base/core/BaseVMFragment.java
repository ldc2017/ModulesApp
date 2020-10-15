package com.ldc.app_base.core;

import androidx.viewbinding.ViewBinding;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.core
 * 作者: liudi
 * 创建时间: 2020/10/11
 */
public abstract class BaseVMFragment<VM extends BaseViewModel, VB extends ViewBinding> extends BaseVBFragment<VB> {
    protected VM viewModel;

    @Override
    protected void initView() {
        viewModel = initViewModel();
        super.initView();
    }

    protected abstract VM initViewModel();
}
