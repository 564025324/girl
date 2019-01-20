package com.lijwen.Login.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * SpringBoot整合filter
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2019/1/20 0020
 * Time:下午 11:40
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("loginFilter - doFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("loginFilter - doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("loginFilter - destory");
    }
}
