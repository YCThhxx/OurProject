package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallFootprint;
import com.cskaoyan.mall.wx.vo.FootprintData;

public interface FootprintService {
     FootprintData getFootprint(int page, int size);

}
