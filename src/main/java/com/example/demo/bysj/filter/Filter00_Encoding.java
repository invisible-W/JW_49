package com.example.demo.bysj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter 0",
        urlPatterns = {"/*"}/*通配符(*)表示对所有的web资源有效*/
)
public class Filter00_Encoding implements Filter {
    public void destroy(){}
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
        throws ServletException, IOException{
        System.out.println("Filter 0 - encoding begins");
        HttpServletRequest request = (HttpServletRequest)req;//强制类型转换
        HttpServletResponse response = (HttpServletResponse)resp;
        //获取映射地址
        String uri = request.getRequestURI();
            resp.setContentType("text/html;charset = UTF-8");
            //是删除、查询功能，则仅设置响应字符编码为UTF-8
            if (request.getMethod().equals("POST") | request.getMethod().equals("PUT")) {
                request.setCharacterEncoding("UTF-8");
            }

        //执行其他过滤器，如过滤器已经执行完毕，则执行原请求
        chain.doFilter(req,resp);
        System.out.println("Filter 0 - encoding ends");
    }

}
