package com.example.springCloud3.business.service;

import com.example.springCloud3.business.domain.User;
import com.example.springCloud3.business.domain.UserExample;
import com.example.springCloud3.business.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public Object queryList() {
        UserExample userExample = new UserExample();
        List<User> list = userMapper.selectByExample(userExample);
        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }

    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}