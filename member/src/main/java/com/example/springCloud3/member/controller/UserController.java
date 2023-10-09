package com.example.springCloud3.member.controller;

import com.example.springCloud3.member.domain.User;
import com.example.springCloud3.member.feign.BusinessFeign;
import com.example.springCloud3.member.service.UserService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/query-list")
    public Object queryList() {
        return userService.queryList();
    }
    @PutMapping("/update")
    public String update(@RequestBody User user) {
        userService.update(user);
        return "ok";
    }

    @PutMapping("/test-seata")
    public String testSeata(@RequestBody User user) throws Exception {
        userService.testSeata(user);
        return "ok";
    }
}
