package com.example.springCloud3.business.controller;

import com.example.springCloud3.business.domain.User;
import com.example.springCloud3.business.service.UserService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;
    @GetMapping("/query-list")
    public Object queryList() {
        return userService.queryList();
    }
    @PutMapping("/update")
    public String update(@RequestBody User user) {
        LOG.info("调用business模块下的update:------");
        userService.update(user);
        return "ok";
    }
}
