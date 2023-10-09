package com.example.springCloud3.member.feign;

import com.example.springCloud3.member.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("business")
public interface BusinessFeign {
    @GetMapping("/business/hello")
    String hello();

    @PutMapping("/business/update")
     void update(User user);
}
