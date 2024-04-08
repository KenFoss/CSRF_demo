package com.demo.csrf.web.rest.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class Authenticate {

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/login-test")
    public ResponseEntity<Map<String,String>> login(HttpServletResponse response) {

        Map<String,String> responseMap = new HashMap<>();

        // Create a new cookie
        Cookie cookie = new Cookie("test-session-id", "123456789");

        // Set the cookie properties
        cookie.setMaxAge(3600); // Set the cookie to expire in 1 hour
        cookie.setPath("/"); // Set the cookie to be accessible from the entire application

        // Add the cookie to the response
        response.addCookie(cookie);

        responseMap.put("SignIn Status", "ok");

        System.out.println("The post was allowed!");

        return ResponseEntity.ok(responseMap);
    }
}