package com.demo.csrf.web.rest.security;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins= "http://localhost:3000", allowCredentials ="true")
@RestController
public class CsrfController {

    @GetMapping("/get-token")
    public ResponseEntity<Map<String, String>> getCsrfToken(HttpServletRequest request, CsrfToken csrfToken) {
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("token!", csrfToken.getToken());
        return ResponseEntity.ok(responseMap);
    }

}
