package com.example.springCloud3.member.controller;

import com.example.springCloud3.member.feign.BusinessFeign;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Value("${test.nacos}")
    private String testNacos;

    @Value("${test.nacos2}")
    private String testNacos2;

    @Autowired
    Environment environment;


    @Resource
    BusinessFeign businessFeign;
    @GetMapping("/hello")
    public String hello() {
        String businessHello = businessFeign.hello();
        LOG.info("feign调用business方法1:------"+businessHello);
//        return "Hello World22!";
        return String.format("Hello %s!", testNacos);
    }

    @GetMapping("/login")
    public String login() {
        return testNacos2;
    }

    @GetMapping("/hello2")
    public String hello2() {
        String port = environment.getProperty("local.server.port");
        return String.format("Hello %s! 端口：%s", testNacos, port);
    }
}