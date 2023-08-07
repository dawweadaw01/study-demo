package com.lhj.designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author banyanmei
 */

@SpringBootApplication
@EnableAspectJAutoProxy
public class DesignPatternsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsApplication.class, args);
    }
}
