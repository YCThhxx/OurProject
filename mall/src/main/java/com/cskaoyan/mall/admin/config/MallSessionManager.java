package com.cskaoyan.mall.admin.config;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class MallSessionManager extends DefaultWebSessionManager {
    //得到前端传过来的sessionId(通过请求头的方式)
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        HttpServletRequest servletRequest = (HttpServletRequest)request;
        String header ;
        header = servletRequest.getHeader("X-cskaoyanmall-Admin-Token");
        if (header ==null && "".equals(header)){
            header = servletRequest.getHeader("X-Litemall-Token");
        }
        if(header != null && !"".equals(header)){
            return header;
        }
        return super.getSessionId(request, response);
    }
}
