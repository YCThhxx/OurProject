package com.cskaoyan.mall.admin.util;

public class PagingUtil {
    private PagingUtil(){
        
    }
    public  static int returnPage(String page){
        page = page == null || page.trim().length() == 0 ? "1":page;
        return Integer.parseInt(page);     
    }
    public  static int returnPageSize(String limit){
        limit = limit == null || limit.trim().length() == 0 ? "20":limit;
        return Integer.parseInt(limit);
    }
}
