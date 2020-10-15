package com.ldc.app_main.model;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_main.model
 * 作者: liudi
 * 创建时间: 2020/10/13
 */
public class ThirdSdkBean {
    private String name;
    private String desc;
    private String url;

    public ThirdSdkBean(String name, String desc, String url) {
        this.name = name;
        this.desc = desc;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
