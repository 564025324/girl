package com.lijwen.girl.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringBoot整合Servlet
 * <p>
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/13 0013
 * Time:下午 9:58
 */

/**
 * <servlet>
 * <servlet-name>Servlet</servlet-name>
 * <servlet-class>com.lijwen.girl.servlet.HelloServlet</servlet-class>
 * </servlet>
 * <p>
 * <servlet-mapping>
 * <servlet-name>Servlet</servlet-name>
 * <url-pattern>/servlet</url-pattern>
 * </servlet-mapping>
 */
@WebServlet(name = "HelloServlet", urlPatterns = "/servlet")
// 等同于上述传统springMVC项目中web.xml的配置
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("--- springBoot整合servlet方法一 -----");
        System.out.println("   使用annotation的方式 ");
    }
}
