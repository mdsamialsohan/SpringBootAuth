package com.springauth.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String greet(HttpServletRequest req){
        return "Hello your session id: " + req.getSession().getId();
    }
    @GetMapping("about")
    public String about()
    {
        return "I am Sohan";
    }
}
