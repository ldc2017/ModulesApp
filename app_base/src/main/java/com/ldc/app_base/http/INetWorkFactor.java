package com.ldc.app_base.http;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.http
 * 作者: liudi
 * 创建时间: 2020/10/12
 */
public interface INetWorkFactor {
    <T extends INetWork> T createHttp(Class<T> tClass, String base_url);

    <T extends INetWork> T createHttp(Class<T> tClass);
}
