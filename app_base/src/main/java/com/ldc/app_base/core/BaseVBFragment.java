package com.ldc.app_base.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.ldc.app_base.config.ModuleAppInit;

import me.jessyan.autosize.internal.CustomAdapt;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.core
 * 作者: liudi
 * 创建时间: 2020/10/11
 */
public abstract class BaseVBFragment<VB extends ViewBinding> extends Fragment implements CustomAdapt {

    protected VB viewBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewBinding = initBinding();
        return viewBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            initView();
            initData();
        } catch (Exception e) {
            initError(e);
        }
    }


    protected abstract VB initBinding();

    protected void initView() {
    }

    protected void initData() {
    }

    protected void initError(Exception e) {
        e.printStackTrace();
    }

    @Override
    public boolean isBaseOnWidth() {
        return ModuleAppInit.isBaseOnWidth;
    }

    @Override
    public float getSizeInDp() {
        return ModuleAppInit.getSizeInDp;
    }
}
