package com.cskaoyan.mall.wx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mall.aliyun")
public class AliyunConfig {
    //id
    String accessKeyId;
    //访问秘钥
    String accessSecret;
    //文件上传
    @Autowired
    MallOssConfig ossConfig;
    //短信发送
    @Autowired
    SmsConfig smsConfig;

    public MallOssConfig getOssConfig() {
        return ossConfig;
    }

    public void setOssConfig(MallOssConfig ossConfig) {
        this.ossConfig = ossConfig;
    }

    public SmsConfig getSmsConfig() {
        return smsConfig;
    }

    public void setSmsConfig(SmsConfig smsConfig) {
        this.smsConfig = smsConfig;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }
}
