package com.demo.csrf.web.rest;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

@RestController
public class CsrfController {

    @GetMapping("/data")
    public String getCsrfToken(HttpServletRequest request) {
        return "Data Obtained";
    }

    @PostMapping("/post-example")
    public String postExample(@RequestBody String requestBody) {
        // Process the request body or perform any necessary operations here
        return "Data Posted Successfully";
    }

}
