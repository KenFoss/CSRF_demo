package com.demo.csrf.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.Arrays;

@Component
public class AuthFilter extends GenericFilterBean {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Cookie[] cookies = httpRequest.getCookies();
        boolean isAuthenticated = false;

        //ignore endpoints
        if(httpRequest.getRequestURI().equalsIgnoreCase("/login-test")) {
            isAuthenticated = true;
        } else if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("test-session-id".equals(cookie.getName()) && "123456789".equals(cookie.getValue())) {
                    System.out.println("Session ID found!");
                    isAuthenticated = true;
                    break;
                }
            }
        }

        if (isAuthenticated) {
            chain.doFilter(request, response);
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpResponse.getWriter().write("Unauthenticated request");
        }
    }
}
