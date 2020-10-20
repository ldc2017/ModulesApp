package com.ldc.app_base.http;

import androidx.annotation.NonNull;

import com.ldc.app_base.http.interceptor.HttpCookieInterceptor;
import com.ldc.app_base.http.interceptor.HttpLogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.http
 * 作者: liudi
 * 创建时间: 2020/10/12
 */
public class Http2Req {
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private Http2Req() {
        //私有化
    }

    private static Http2Req getInstance() {
        return Single.S;
    }

    //创建一个服务
    public static <T> T createService(Class<T> tClass) {
        return getInstance().getRetrofit().create(tClass);
    }

    //创建一个服务
    public static <T> T createService(@NonNull String base_url, Class<T> tClass) {
        return getInstance().getRetrofit(base_url).create(tClass);
    }

    private OkHttpClient getOkHttpClient() {
        if (null == okHttpClient) {
            //
            HttpLoggingInterceptor logs = new HttpLoggingInterceptor(new HttpLogInterceptor());
            logs.setLevel(HttpLoggingInterceptor.Level.BODY);
            //
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(logs)
                    .cookieJar(new HttpCookieInterceptor())
                    .build();
        }
        return okHttpClient;
    }

    private Retrofit getRetrofit() {
        return getRetrofit(HttpConfig.base_url);
    }

    private Retrofit getRetrofit(String base_url) {
        retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build();
        return retrofit;
    }

    private static class Single {
        private static volatile Http2Req S = new Http2Req();
    }
}
