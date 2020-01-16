package com.lianweiq.shard_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianweiq.shard_demo.entity.User;
import com.lianweiq.shard_demo.mapper.UserMapper;
import com.lianweiq.shard_demo.service.SnowFlake;
import com.lianweiq.shard_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author dayang
 * @since 2020-01-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private SnowFlake snowFlake;

    @Override
    public boolean batchSave(Collection<User> entityList) {
        for (User user : entityList) {
            user.setId(snowFlake.nextId());
        }
        return super.saveBatch(entityList);
    }


    @Override
    public boolean save(User entity) {
        entity.setId(snowFlake.nextId());
        return super.save(entity);
    }
}
