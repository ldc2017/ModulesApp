package com.ldc.app_base.http;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.http
 * 作者: liudi
 * 创建时间: 2020/10/12
 */
public final class NetWorkFactor implements INetWorkFactor {
    private static class Single {
        private static volatile NetWorkFactor S = new NetWorkFactor();
    }

    private NetWorkFactor() {
    }

    public static NetWorkFactor getInstance() {
        return Single.S;
    }

    @Override
    public <T extends INetWork> T createHttp(Class<T> tClass, String base_url) {
        INetWork iNetWork = null;
        try {
            iNetWork = (INetWork) Class.forName(tClass.getName()).newInstance();
            iNetWork.baseUrl(base_url);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) iNetWork;
    }

    @Override
    public <T extends INetWork> T createHttp(Class<T> tClass) {
        INetWork iNetWork = null;
        try {
            iNetWork = (INetWork) Class.forName(tClass.getName()).newInstance();
            iNetWork.baseUrl(ApiConfig.base_url);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) iNetWork;
    }
}
