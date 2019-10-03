package com.cskaoyan.mall.admin.vo;


public class BaseResponseVo<T> {
    T data;
    String errmsg;
    int errno;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public static BaseResponseVo ok(Object data){
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        baseResponseVo.setData(data);
        baseResponseVo.setErrmsg("成功");
        baseResponseVo.setErrno(0);
        return baseResponseVo;
    }

    public static BaseResponseVo ok(){
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        baseResponseVo.setErrmsg("成功");
        baseResponseVo.setErrno(0);
        return baseResponseVo;
    }

    public static BaseResponseVo fail(String msg,int errno){
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        baseResponseVo.setErrmsg(msg);
        baseResponseVo.setErrno(errno);
        return baseResponseVo;
    }
}
