package com.lianweiq.shard_demo.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: shard_demo
 * @description: 基础实体类
 * @author: lianweiq
 * @create: 2020-01-14 17:26
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    @TableId(value = "id",type = IdType.INPUT)
    private Long id;

}
