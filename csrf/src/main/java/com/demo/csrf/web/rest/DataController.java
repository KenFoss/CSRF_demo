package com.demo.csrf.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins= "*")
@RestController("/data")
public class DataController {


    //    @CrossOrigin("http://localhost:3000")
    @GetMapping("/get-data")
    public ResponseEntity<Map<String, String>> getData() {
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("data", "some_data");
        return ResponseEntity.ok(responseMap);
    }

    @PostMapping("/post-example")
    public String postExample(@RequestBody String requestBody) {
        // Process the request body or perform any necessary operations here
        return "Data Posted Successfully";
    }

}
