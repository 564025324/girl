package com.lijwen;

import com.lijwen.Login.filter.LoginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

/**
 * springBoot的启动器:要放在controller同级和上级目录中
 *
 * @author lijingwen
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.lijwen.sell.service"})
@ServletComponentScan
// 注册servlet方法一，扫描WebServlet的注解并实例化，配合本项目中HelloServlet.java使用
// 注册filter方法一，扫描WebServlet的注解并实例化，配合本项目中HelloFilter.java使用

public class SellApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }

    //    @Bean // 注册servlet方法二
    //    public ServletRegistrationBean getServletRegistrationBean() {
    //        ServletRegistrationBean bean = new ServletRegistrationBean(new HelloServlet2());
    //        bean.addUrlMappings("/servlet2");
    //        return bean;
    //    }

    //    @Bean // 注册filter方法二
    //    public FilterRegistrationBean getServletRegistrationBean() {
    //        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
    //        bean.addUrlPatterns("/*");
    //        return bean;
    //    }

    @Bean
    public FilterRegistrationBean getServletRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new LoginFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }

}


