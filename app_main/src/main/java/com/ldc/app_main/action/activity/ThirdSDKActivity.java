package com.ldc.app_main.action.activity;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ldc.app_base.core.BaseVBActivity;
import com.ldc.app_main.AppInit;
import com.ldc.app_main.adapter.ThirdSdkAdapter;
import com.ldc.app_main.databinding.ActivityThirdSdkBinding;


public class ThirdSDKActivity extends BaseVBActivity<ActivityThirdSdkBinding> {
    private ThirdSdkAdapter thirdSdkAdapter;

    @Override
    protected ActivityThirdSdkBinding initBinding() {
        return ActivityThirdSdkBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        super.initView();
        Log.e(TAG, String.format("initView: %s", AppInit.getApplication().getClass().getName()));
        initAdapter();
    }

    private void initAdapter() {
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        if (null == thirdSdkAdapter) {
            thirdSdkAdapter = new ThirdSdkAdapter();
        }
        viewBinding.dataList.setLayoutManager(layoutManager);
        viewBinding.dataList.setHasFixedSize(true);
        viewBinding.dataList.setAdapter(thirdSdkAdapter);
    }
}