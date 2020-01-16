package com.lianweiq.shard_demo.service;

import com.lianweiq.shard_demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author dayang
 * @since 2020-01-14
 */
public interface UserService extends IService<User> {

     boolean batchSave(Collection<User> entityList);

}
