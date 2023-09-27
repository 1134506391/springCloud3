package com.example.springCloud3.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CommonApplication {
    private static final Logger LOG = LoggerFactory.getLogger(CommonApplication.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CommonApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("测试地址: \thttp://127.0.0.1:{}/hello", env.getProperty("server.port"));
    }
}
