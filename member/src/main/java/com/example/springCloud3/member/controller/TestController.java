package com.example.springCloud3.member.controller;

import com.example.springCloud3.member.feign.BusinessFeign;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Resource
    BusinessFeign businessFeign;
    @GetMapping("/hello")
    public String hello() {
        String businessHello = businessFeign.hello();
        LOG.info("feign调用business方法:------"+businessHello);
        return "Hello World22!";
    }

    @GetMapping("/login")
    public String login() {
        return "login22";
    }
}