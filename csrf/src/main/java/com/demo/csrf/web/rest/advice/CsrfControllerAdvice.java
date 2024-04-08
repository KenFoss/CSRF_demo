package com.demo.csrf.web.rest.advice;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

@ControllerAdvice
public class CsrfControllerAdvice {

    @ModelAttribute
    public void getCsrfToken(HttpServletResponse response, CsrfToken csrfToken) {
        System.out.println("getting token");
        if(response.containsHeader("Set-Cookie")){
            ArrayList<String> newHeaders = response.getHeaders("Set-Cookie").stream().filter( (String x) -> {
                if(x.contains("XSRF-TOKEN")) {
                    System.out.println("to Remove");
                    System.out.println(x);
                    return false;
                }
                return true;
            }).collect(Collectors.toCollection(ArrayList::new));
        }
    }

}