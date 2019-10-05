package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.util.DataUtil;

public interface GrouponService {

   DataUtil getGrouponList(int page, int size);

    DataUtil getGrouponMy(int showType, int userId);
}
