package com.demo.csrf.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CsrfController {
//    @GetMapping("/csrf")
//    public CsrfToken csrf(CsrfToken csrfToken) {
//        return csrfToken;
//    }
    @GetMapping("/help")
    public ResponseEntity idk(){
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/csrf-token")
    public String getCsrfToken(HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (csrfToken != null) {
            return csrfToken.getToken();
        } else {
            return "CSRF token not found";
        }
    }

    @PostMapping("/post-example")
    public String postExample(@RequestBody String requestBody) {
        // Process the request body or perform any necessary operations here
        return "Data received successfully";
    }

}
