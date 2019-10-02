package com.cskaoyan.mall.admin.vo.grouponvo;

public class SubGrouponsVo {

    private int orderId;
    private int userId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SubGrouponsVo{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                '}';
    }
}
