package com.ldc.app_base.core;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.blankj.utilcode.util.BarUtils;
import com.ldc.app_base.config.ModuleConfig;

import me.jessyan.autosize.internal.CustomAdapt;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.core
 * 作者: liudi
 * 创建时间: 2020/10/10
 */
public abstract class BaseVBActivity<VB extends ViewBinding> extends AppCompatActivity implements CustomAdapt {
    protected Activity activity;
    protected VB viewBinding;
    protected final String TAG = this.getClass().getName();


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            viewBinding = initBinding();
            setContentView(viewBinding.getRoot());
            activity = this;
            initView();
            initData();
        } catch (Exception e) {
            initError(e);
        }
    }

    /**
     * 建议在加载contentView完成前后使用
     *
     * @param color
     * @param isLight
     */
    protected void initStatusBar(@NonNull final int color, @NonNull final boolean isLight) {
        BarUtils.setStatusBarLightMode(this, isLight);
        BarUtils.setStatusBarColor(this, color, false);
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
        return ModuleConfig.isBaseOnWidth;
    }

    @Override
    public float getSizeInDp() {
        return ModuleConfig.getSizeInDp;
    }
}
