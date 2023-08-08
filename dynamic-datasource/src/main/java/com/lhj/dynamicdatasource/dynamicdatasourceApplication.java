package com.lhj.dynamicdatasource;


import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author banyanmei
 */
@SpringBootApplication
@MapperScan(value = "com.lhj.dynamicdatasource.mapper")
public class dynamicdatasourceApplication {
    public static void main(String[] args) {
        LogFactory.useCustomLogging(StdOutImpl.class);
        SpringApplication.run(dynamicdatasourceApplication.class, args);
    }
}
