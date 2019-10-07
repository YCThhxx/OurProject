package com.cskaoyan.mall.wx.vo.orderVo;

import java.util.List;

public class OrderTotalVo {
    List<OrderListVo> data;
    int count;
    int totalPages;

    public OrderTotalVo(List<OrderListVo> orderlist, int count) {
        this.data = orderlist;
        this.count = count;
        this.totalPages = (count%10==0)?(count/10):(count/10+1);
    }

    @Override
    public String toString() {
        return "OrderTotalVo{" +
                "data=" + data +
                ", count=" + count +
                ", totalPages=" + totalPages +
                '}';
    }

    public List<OrderListVo> getData() {
        return data;
    }

    public void setData(List<OrderListVo> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
