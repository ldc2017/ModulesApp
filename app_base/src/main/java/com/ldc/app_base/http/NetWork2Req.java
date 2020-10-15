package com.ldc.app_base.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.http
 * 作者: liudi
 * 创建时间: 2020/10/12
 */
public class NetWork2Req implements INetWork {
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private String base_url;

    public NetWork2Req() {
        init();
    }


    private void init() {
        if (null == okHttpClient) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        if (null == retrofit) {
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(base_url)
                    .build();
        }

    }

    @Override
    public void baseUrl(String base_url) {
        this.base_url = base_url;
    }

    @Override
    public <T> T createService(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
