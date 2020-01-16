package com.lianweiq.shard_demo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @program: shard_demo
 * @description: 性别
 * @author: lianweiq
 * @create: 2020-01-14 17:27
 */
public enum  Sex {

    MAIL(1,"男"),
    FEMAIL(2,"女")
    ;

    @EnumValue
    private int  code;

    private String desc;

    Sex(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
