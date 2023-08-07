package com.lhj.dynamicdatasource;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lhj.dynamicdatasource.mapper")
public class dynamicdatasourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(dynamicdatasourceApplication.class, args);
    }
}
