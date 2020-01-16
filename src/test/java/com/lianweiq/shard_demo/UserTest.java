package com.lianweiq.shard_demo;

import com.lianweiq.shard_demo.entity.User;
import com.lianweiq.shard_demo.enums.Sex;
import com.lianweiq.shard_demo.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: shard_demo
 * @description: 用户测试类
 * @author: lianweiq
 * @create: 2020-01-16 17:10
 */
public class UserTest extends BaseTest{
    @Autowired
    private UserService userService;

    @Test
    public void forInsert(){
        for (int i=0;i<10000;i++){
            test1();
            test2();
            test3();test4();
        }
    }

    public void test1(){
        User user = User.builder()
                .age(12)
                .name("秦连伟")
                .sex(Sex.MAIL)
                .build();
        userService.save(user);
    }
    public void test2(){
        User user = User.builder()
                .age(13)
                .name("秦连伟")
                .sex(Sex.MAIL)
                .build();
        userService.save(user);
    }
    public void test3(){
        User user = User.builder()
                .age(14)
                .name("秦连伟")
                .sex(Sex.MAIL)
                .build();
        userService.save(user);
    }
    public void test4(){
        User user = User.builder()
                .age(15)
                .name("秦连伟")
                .sex(Sex.MAIL)
                .build();
        userService.save(user);
    }

}
