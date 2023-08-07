package com.lhj.dynamicdatasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author banyanmei
 */
@Configuration
public class MybatisConfig {

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.master")
    public DataSource masterDataSource() {
        //注入配置生成datasourcebean
        return new com.zaxxer.hikari.HikariDataSource();
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.slave")
    public DataSource slaveDataSource() {
        //注入配置生成datasourcebean
        return new com.zaxxer.hikari.HikariDataSource();
    }
}
