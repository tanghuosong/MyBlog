package com.ths.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;


public class EncodingFilter extends HttpServlet implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤内容：" + response.getCharacterEncoding());
        String page = request.getParameter("page");
//        if (page == null || page == "") {
//            request.getParameterMap().put("page", new String[]{"0"});
//        } else {
//
//            request.getParameterMap().remove("page");
//            Integer pageI = 0;
//            try {
//                pageI = Integer.valueOf(page);
//            } catch (Exception ex) {
//
//            }
//            pageI = pageI >= 0 ? pageI : 0;
//            request.getParameterMap().put("page", new String[]{String.valueOf(pageI)});
//        }
        if (response.getCharacterEncoding() != "UTF-8") {
            response.setCharacterEncoding("UTF-8");
        }
        filterChain.doFilter(request, response);
        System.out.println("过滤结束");
    }

    @Override
    public void destroy() {
    }
}