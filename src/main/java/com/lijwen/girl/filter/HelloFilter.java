package com.lijwen.girl.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * SpringBoot整合Filter
 * <p>
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/13 0013
 * Time:下午 10:23
 */

/**
 * 传统SpringMVC的web.xml配置filter
 * <filter>
 * <filter-name>filter</filter-name>
 * <filter-class>com.lijwen.girl.filter.HelloFilter</filter-class>
 * </filter>
 * <filter-mapping>
 * <filter-name>filter</filter-name>
 * <url-pattern>/filter</url-pattern>
 * </filter-mapping>
 */
@WebFilter(filterName = "HelloFilter", urlPatterns = {"/filter"})
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入Filter");
        chain.doFilter(request, response);
        System.out.println("离开Filter");
    }

    @Override
    public void destroy() {

    }
}
