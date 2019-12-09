package com.example.demo.bysj.security;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showCookies")
public class ShowCookies extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        String title = "Active Cookies";
        out.println("<html><head><title>获取客户端Cookie</title></head>" +
                "<BODY BGCOLOR=\"#c1cbd7\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                "<TR BGCOLOR=\"#9ca8b8\">\n" +
                "  <TH>Cookie Name\n" +
                "  <TH>Cookie Value");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie cookie;
            for(int i=0; i<cookies.length; i++) {
                cookie = cookies[i];
                out.println("<TR>\n" +
                        "  <TD>" + cookie.getName() + "</TD>\n" +
                        "  <TD>" + cookie.getValue() + "</TD></TR>\n" );
            }    }    out.println("</TABLE></BODY></HTML>");
    }

}
