package com.hp.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuUser extends ZuulFilter {
    @Override
    public String filterType() {
       //转发之前
        return  FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //请求头之前查看参数
        return  FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        //需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取方法
        //获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取request请求
        HttpServletRequest request = currentContext.getRequest();
        //获取值
        String token = request.getParameter("access-token");
        if(StringUtils.isBlank(token)){
            //不存在，未登陆，则拦截
            currentContext.setSendZuulResponse(false);
            //返回403
            currentContext.setResponseStatusCode(403);
        }
        return null;
    }
}
