package com.lianweiq.shard_demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: shard_demo
 * @description: 数据库连接配置
 * @author: lianweiq
 * @create: 2020-01-14 18:04
 */
@PropertySource(value = {"classpath:jdbc.properties"})
@Configuration
@Data
public class JdbcConfig {

    @Value("${jdbc.url1}")
    private String url1;

    @Value("${jdbc.user1}")
    private String user1;

    @Value("${jdbc.pwd1}")
    private String pwd1;

    @Value("${jdbc.url2}")
    private String url2;

    @Value("${jdbc.user2}")
    private String user2;

    @Value("${jdbc.pwd2}")
    private String pwd2;

    @Value("${jdbc.className}")
    private String className;



}
