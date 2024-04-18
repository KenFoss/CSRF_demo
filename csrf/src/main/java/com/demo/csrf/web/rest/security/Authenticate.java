package com.demo.csrf.web.rest.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins="http://localhost:3000", allowCredentials ="true")
@RestController
public class Authenticate {


    @PostMapping ("/login-test")
    public ResponseEntity<Map<String,String>> login(HttpServletResponse response) {

        Map<String,String> responseMap = new HashMap<>();

        String cookieValue = "test-session-id=123456789; Max-Age=3600; Path=/; SameSite=None; Secure";
        response.addHeader("Set-Cookie", cookieValue);

        responseMap.put("SignIn Status", "ok");

        return ResponseEntity.ok(responseMap);
    }
}