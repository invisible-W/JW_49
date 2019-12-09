package com.example.demo.bysj.security;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/createSession")
public class CreateSession extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //如果当前请求对应着服务器的一个session对象，返回
        //如果服务器内存中的没有session对象与当前请求响应，创建一个session对象并返回
        HttpSession session = request.getSession();
        //如果session不活跃间隔大于5秒，则该session失败
        session.setMaxInactiveInterval(5);
        response.getWriter().println("session will last 5 seconds");

    }
}
