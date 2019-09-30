package com.cskaoyan.mall.admin.convert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2StringConvert {
    public static String newDateInstance(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-rr HH:mm:ss");
        Date date = new Date();
        String format = dateFormat.format(date);
        return format;
    }

}
