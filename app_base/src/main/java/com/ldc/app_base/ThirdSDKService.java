package com.ldc.app_base;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base
 * 作者: liudi
 * 创建时间: 2020/10/11
 */
public class ThirdSDKService extends JobIntentService {


    /**
     * @param context
     * @param data    不能为null
     */
    public static void start(Context context, @NonNull Intent data) {
        enqueueWork(context, ThirdSDKService.class, 0x999, data);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        try {
            if (BuildConfig.DEBUG) {
                ARouter.openLog();     // 打印日志
                ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            }
            ARouter.init(getApplication());
            Utils.init(getApplication());
        } catch (Exception e) {
            System.err.println(String.format("初始化异常 ： %s", e.getLocalizedMessage()));
        }

    }
}
