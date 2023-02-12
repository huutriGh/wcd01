package com.aptech.wcd01.Filters;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(value = "/*")
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        servletRequest.getServletContext().log(String.format("Log From filter: Request made to %s, Method: %s", req.getRequestURI(), req.getMethod()));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
