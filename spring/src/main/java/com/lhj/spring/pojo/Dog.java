package com.lhj.spring.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @description：
 * @createTime：2023-10-0212:07
 * @author：banyanmei
 */
@Data
@Component
public class Dog {
    private String name;
    private Integer age;
}
