package com.swjd.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//自定义拦截器
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //写放行的条件
        String uri=request.getRequestURI();//获取当前用户请求访问的地址

        //1.不需要登陆就可以访问的页面
        if (uri.indexOf("login")>=0||uri.indexOf("Login")>=0){
            return true;//放行
        }
        if (uri.indexOf("main")>=0||uri.indexOf("Main")>=0){
            return true;//放行
        }

        //2.需要登陆之后才能访问的页面（已经登陆过了）
        HttpSession session=request.getSession();
        if (session.getAttribute("activeName")!=null){
            return true;
        }

        //无条件访问
        request.getRequestDispatcher("/toLogin").forward(request,response);
        return false;
    }
}
