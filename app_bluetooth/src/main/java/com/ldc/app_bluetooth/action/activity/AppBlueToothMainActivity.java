package com.ldc.app_bluetooth.action.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ldc.app_base.core.BaseVBActivity;
import com.ldc.app_bluetooth.R;
import com.ldc.app_bluetooth.action.fragment.DeviceFragment;
import com.ldc.app_bluetooth.action.fragment.MessageFragment;
import com.ldc.app_bluetooth.action.fragment.SettingFragment;
import com.ldc.app_bluetooth.databinding.BleActivityAppBlueToothBinding;


public class AppBlueToothMainActivity extends BaseVBActivity<BleActivityAppBlueToothBinding> {
    private Fragment currFragment = new Fragment();


    public static void start(Context context) {
        final ComponentName componentName = new ComponentName(context, AppBlueToothMainActivity.class);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        context.startActivity(intent);

    }


    @Override
    protected BleActivityAppBlueToothBinding initBinding() {
        return BleActivityAppBlueToothBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        super.initView();
        //默认消息页面
        switchFragment(MessageFragment.newInstance());
        //
        viewBinding.titleBar.llLeft.setOnClickListener(v -> {
            finish();
        });
        viewBinding.titleBar.tvTitle.setText("消息");
        viewBinding.titleBar.llRight.setOnClickListener(v -> {
            showMoreDialog();
        });
    }

    //显示跟多对话框
    private void showMoreDialog() {
        final View view = LayoutInflater.from(activity).inflate(R.layout.ble_view_dialog_more, null, false);
        TextView tvMessage = (TextView) view.findViewById(R.id.tv_message);
        TextView tvDevice = (TextView) view.findViewById(R.id.tv_device);
        TextView tvSetting = (TextView) view.findViewById(R.id.tv_setting);
        //
        final PopupWindow alertDialog = new PopupWindow(activity);
        alertDialog.setContentView(view);
        alertDialog.setBackgroundDrawable(new ColorDrawable(0x00000000));
        alertDialog.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        alertDialog.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        alertDialog.setOutsideTouchable(false);
        alertDialog.showAtLocation(viewBinding.llLayout, Gravity.NO_GRAVITY, 0, 0);
        //
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                final int id = view.getId();
                if (id == R.id.tv_message) {
                    viewBinding.titleBar.tvTitle.setText("消息");
                    switchFragment(MessageFragment.newInstance());
                } else if (id == R.id.tv_device) {
                    viewBinding.titleBar.tvTitle.setText("设备");
                    switchFragment(DeviceFragment.newInstance());
                } else if (id == R.id.tv_setting) {
                    viewBinding.titleBar.tvTitle.setText("设置");
                    switchFragment(SettingFragment.newInstance());
                }

            }
        };
        tvMessage.setOnClickListener(onClickListener);
        tvDevice.setOnClickListener(onClickListener);
        tvSetting.setOnClickListener(onClickListener);
    }


    //切换页面
    private void switchFragment(Fragment target) {
        if (currFragment == target) return;
        final FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (null != currFragment) {
            beginTransaction.hide(currFragment);
        }
        if (target.isAdded()) {
            beginTransaction.show(target);
        } else {
            beginTransaction.add(viewBinding.flFragment.getId(), target, target.getClass().getName());
        }
        beginTransaction.commit();
        currFragment = target;


    }
}