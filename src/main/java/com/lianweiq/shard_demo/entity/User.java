package com.lianweiq.shard_demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lianweiq.shard_demo.common.BaseEntity;
import com.lianweiq.shard_demo.enums.Sex;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author dayang
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Builder
@TableName("user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 姓名
     */
    private Integer age;

    /**
     * 年龄
     */
    private Sex sex;


}
