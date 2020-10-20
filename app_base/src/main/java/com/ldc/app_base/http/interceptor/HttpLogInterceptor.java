package com.ldc.app_base.http.interceptor;

import com.ldc.app_base.BuildConfig;

import org.jetbrains.annotations.NotNull;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 项目: ModulesApp
 * 包名: com.ldc.app_base.http
 * 作者: liudi
 * 创建时间: 2020/10/20
 */
public class HttpLogInterceptor implements HttpLoggingInterceptor.Logger {
    private static final String TAG = "【网络日志】";

    @Override
    public void log(@NotNull String s) {
        final String message = String.format("%s %s ", TAG, s);
        if (BuildConfig.DEBUG) {
            System.err.println(message);
        }

    }
}
