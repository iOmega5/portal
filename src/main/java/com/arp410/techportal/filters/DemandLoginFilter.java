package com.arp410.techportal.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DemandLoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();

        Boolean auth = (Boolean) session.getAttribute("auth");
        if (auth == null || !auth) {
            response.sendRedirect("../index.jsp");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
