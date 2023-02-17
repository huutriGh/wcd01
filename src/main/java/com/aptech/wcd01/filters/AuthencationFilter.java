package com.aptech.wcd01.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthencationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        boolean isLoginPage = request.getRequestURI().contains("/login.jsp");
        boolean isServletLoginUrl =
                (request.getRequestURI().contains(request.getContextPath() + "/login") ||
                        request.getRequestURI().endsWith(request.getContextPath() + "/"));
        boolean isLogin = (session != null && session.getAttribute("user") != null);

        if (isLogin && (isLoginPage || isServletLoginUrl)) {
            request.getRequestDispatcher("/list").forward(servletRequest, servletResponse);
        } else if (!isLogin && !(isLoginPage || isServletLoginUrl)) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

//        if (session == null) {
//            this.context.log("Unauthorized access request");
//            response.sendRedirect(request.getContextPath() + "/login.jsp");
//        } else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
    }
}
