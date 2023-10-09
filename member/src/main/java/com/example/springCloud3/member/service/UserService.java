package com.example.springCloud3.member.service;

import com.example.springCloud3.member.controller.UserController;
import com.example.springCloud3.member.domain.User;
import com.example.springCloud3.member.domain.UserExample;
import com.example.springCloud3.member.feign.BusinessFeign;
import com.example.springCloud3.member.mapper.UserMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Resource
    BusinessFeign businessFeign;
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

    @GlobalTransactional
    public void testSeata(User user) throws Exception{
        LOG.info("seata全局事务ID: {}", RootContext.getXID());
        userMapper.updateByPrimaryKeySelective(user);
        businessFeign.update(user);
        //自己制造异常
//        if (1 == 1) {
//            throw new Exception("测试异常");
//        }
    }
}
