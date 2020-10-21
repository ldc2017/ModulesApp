package com.ldc.app_base.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ldc.app_base.config.ModuleAppInit;

import me.jessyan.autosize.internal.CustomAdapt;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.core
 * 作者: liudi
 * 创建时间: 2020/10/11
 */
public abstract class BaseFragment extends Fragment implements CustomAdapt {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return createView(inflater, container, savedInstanceState);
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

    protected View createView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = LayoutInflater.from(getContext()).inflate(ui(), container, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    protected abstract int ui();

    protected void initView() {
    }

    protected void initData() {
    }

    protected void initError(Exception e) {
        System.err.println(String.format("【 异常 】========== %s", e.getMessage()));
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
