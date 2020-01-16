package com.lianweiq.shard_demo.controller;

import com.lianweiq.shard_demo.entity.User;
import com.lianweiq.shard_demo.enums.Sex;
import com.lianweiq.shard_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: shard_demo
 * @description: 用户信息
 * @author: lianweiq
 * @create: 2020-01-16 17:47
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("save")
    public void save(){
                User user = com.lianweiq.shard_demo.entity.User.builder()
                .age(12)
                .name("秦连伟")
                .sex(Sex.MAIL)
                .build();
        userService.save(user);
    }

}
