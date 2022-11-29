package com.my.store.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Configuration
public class LoginInterceptor implements HandlerInterceptor {

    /**
     *  在调用所有处理请求的方法之前被自动调用执行
     *
     *  在此处检测全局session对象进行判断是否登录了
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("即将进行处理请求");

        // getAttribute返回为对象，需要转成String,再转成Integer
        Object uid =
                request.getSession().getAttribute("uid");

        if(uid == null ){
            // 说明用户没有登录，
            response.sendRedirect("/web/login.html");
            return false;
        }

        return true;
    }

    /**
     * 在ModelAndView对象返回之后被调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("模型与视图处理完毕");
    }

    /**
     * 在整个请求所有关联的资源被执行完毕最后所执行的方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("所有请求处理完毕");
    }
}
