package com.example.controller;

import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    private final TestService testService;
    
    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }
    
    @RequestMapping(path = "/test")
    public String test(){
        return testService.test();
    }
}
