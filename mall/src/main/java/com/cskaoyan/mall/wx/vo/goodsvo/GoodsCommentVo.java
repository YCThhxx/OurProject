package com.cskaoyan.mall.wx.vo.goodsvo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallComment;

import java.util.List;

public class GoodsCommentVo {

    List<CskaoyanMallComment> data;
    long count;

    public List<CskaoyanMallComment> getData() {
        return data;
    }

    public void setData(List<CskaoyanMallComment> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
