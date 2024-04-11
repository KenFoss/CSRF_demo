package com.demo.csrf.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins= {"http://localhost:3000","http://localhost:3001", "https://www.google.com"}, allowCredentials ="true")
@RestController()
public class DataController {

    @GetMapping("/get-data")
    public ResponseEntity<Map<String, String>> getData() {
        Map<String, String> responseMap = new HashMap<>();
        return ResponseEntity.ok(responseMap);
    }

    // Simple post endpoint to attack
    @PostMapping("/post-example")
    public String postExample(@RequestBody String requestBody) {
        return "Data Posted Successfully";
    }

}
