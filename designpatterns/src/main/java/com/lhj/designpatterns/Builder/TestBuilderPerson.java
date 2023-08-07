package com.lhj.designpatterns.Builder;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author banyanmei
 * @builder注解可以直接生成创建者模式的代码
 */
@Getter
@ToString
@Builder
public class TestBuilderPerson {
    private String name;
    private int age;
    private String address;

    public static void main(String[] args) {
        TestBuilderPerson testBuilderPerson = TestBuilderPerson.builder().name("aa").age(1).address("bb").build();
        System.out.println(testBuilderPerson);
    }
}
