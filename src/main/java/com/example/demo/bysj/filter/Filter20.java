package com.example.demo.bysj.filter;//package filter;
//
//import com.alibaba.fastjson.JSONObject;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(filterName = "Filter 2",urlPatterns = "/*")
//public class Filter20 implements Filter {
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        //轻质类型转换
//        System.out.println("Filter 2 - encoding begins");
//        HttpServletRequest request = (HttpServletRequest)req;
//        HttpServletResponse response = (HttpServletResponse)resp;
//        //创建JSON对象message，以便向前端响应信息
//        JSONObject message = new JSONObject();
//        //获得path
//        String path = request.getRequestURI();
//        //访问权限验证
//        HttpSession session=request.getSession();
//        // Object currentUser=session.getAttribute("currentUser");
//        if (!path.contains("/login")) {
//            if (session == null || session.getAttribute("currentUser") == null) {
//                message.put("message", "您没有登录，请登录");
//                //响应到message前端
//                response.getWriter().println(message);
//                return;
//            }
//        }
//        chain.doFilter(req, resp);//执行其他过滤器，如果过滤器已经执行完毕，则执行原请求
//        System.out.println("Filter 2 - encoding ends");
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
//
