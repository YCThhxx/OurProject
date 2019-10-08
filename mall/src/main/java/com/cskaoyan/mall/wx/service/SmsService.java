package com.cskaoyan.mall.wx.service;

public interface SmsService {
    boolean sendMessage(String mobile, String code);
}
