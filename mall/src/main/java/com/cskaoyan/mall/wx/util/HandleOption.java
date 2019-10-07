package com.cskaoyan.mall.wx.util;

public class HandleOption {
    boolean cancel;

    boolean comment;

    boolean confirm;

    boolean delete;

    boolean pay;

    boolean rebuy;

    boolean refund;

    public HandleOption() {
    }

    public HandleOption(int status){
        if (status == 101){
            this.cancel = true;
            this.delete = false;
            this.pay = true;
            this.comment = false;
            this.confirm = false;
            this.refund = false;
            this.rebuy = false;
        }
        else if (status == 201){
            this.cancel = true;
            this.delete = false;
            this.pay = false;
            this.comment = false;
            this.confirm = false;
            this.refund = false;
            this.rebuy = false;
        }else if (status == 301){
            this.cancel = false;
            this.delete = false;
            this.pay = false;
            this.comment = false;
            this.confirm = true;
            this.refund = false;
            this.rebuy = false;
        }else if (status == 401){
            this.cancel = false;
            this.delete = false;
            this.pay = false;
            this.comment = true;
            this.confirm = false;
            this.refund = false;
            this.rebuy = false;
        }else {
            this.cancel = false;
            this.delete = false;
            this.pay = false;
            this.comment = false;
            this.confirm = false;
            this.refund = false;
            this.rebuy = false;
        }
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public boolean isRebuy() {
        return rebuy;
    }

    public void setRebuy(boolean rebuy) {
        this.rebuy = rebuy;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }
}
