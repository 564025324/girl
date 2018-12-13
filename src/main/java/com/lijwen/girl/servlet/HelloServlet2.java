package com.lijwen.girl.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/13 0013
 * Time:下午 10:15
 */
public class HelloServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("--- springBoot整合servlet方法二 -----");
        System.out.println("   使用方法配置的方式 ");
    }
}
