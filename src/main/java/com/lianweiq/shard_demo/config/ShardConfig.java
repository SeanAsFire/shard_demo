package com.lianweiq.shard_demo.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: shard_demo
 * @description: 分库分表配置
 * @author: lianweiq
 * @create: 2020-01-14 18:08
 */
@Configuration
public class ShardConfig {

    @Autowired
    private JdbcConfig jdbcConfig;

    @Bean
    @Primary
    public DataSource getDadasource() throws SQLException {
        Map<String, DataSource> dataSourceMap = Maps.newHashMap();
        dataSourceMap.put("test0",createDb0());
        dataSourceMap.put("test1",createDb1());

        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        shardingRuleConfiguration.getTableRuleConfigs().add(userRuleConfig());

        Properties p = new Properties();
        p.setProperty("sql.show",Boolean.TRUE.toString());
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfiguration, new ConcurrentHashMap(), p);
        return dataSource;
    }

    private TableRuleConfiguration userRuleConfig(){
        TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration();
        tableRuleConfiguration.setLogicTable("user");
        tableRuleConfiguration.setActualDataNodes("test${0..1}.user${0..1}");
        tableRuleConfiguration.setKeyGeneratorColumnName("id");
        //数据库分片策略
        tableRuleConfiguration.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "test${id % 2}"));
        //表分片策略
        tableRuleConfiguration.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("age", "user${age % 2}"));
        return tableRuleConfiguration;
    }

    private DruidDataSource createDb0(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcConfig.getClassName());
        dataSource.setUrl(jdbcConfig.getUrl2());
        dataSource.setUsername(jdbcConfig.getUser2());
        dataSource.setPassword(jdbcConfig.getPwd2());
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(5);
        return dataSource;
    }

    private DruidDataSource createDb1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcConfig.getClassName());
        dataSource.setUrl(jdbcConfig.getUrl1());
        dataSource.setUsername(jdbcConfig.getUser1());
        dataSource.setPassword(jdbcConfig.getPwd1());
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(5);
        return dataSource;
    }

    @Bean
    public Filter statFilter(){
        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(5000);
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        return filter;
    }


}
