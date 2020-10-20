package com.ldc.app_base.http.interceptor;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * 项目: ModulesApp
 * 包名: com.ldc.app_base.http.interceptor
 * 作者: liudi
 * 创建时间: 2020/10/20
 */
public class HttpCookieInterceptor implements CookieJar {
    private HashMap<String, List<Cookie>> hashMap = new HashMap<>();

    @NotNull
    @Override
    public List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl) {
        List<Cookie> cookies = hashMap.get(httpUrl.host());
        return null == cookies ? new ArrayList<>() : cookies;
    }

    @Override
    public void saveFromResponse(@NotNull HttpUrl httpUrl, @NotNull List<Cookie> list) {
        hashMap.put(httpUrl.host(), list);

    }
}
