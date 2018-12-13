package com.lijwen.girl.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * SpringBoot整合Filter 方法二
 * <p>
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/13 0013
 * Time:下午 10:37
 */
public class SecondFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入SecondFilter");
        chain.doFilter(request, response);
        System.out.println("离开SecondFilter");
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }
}
