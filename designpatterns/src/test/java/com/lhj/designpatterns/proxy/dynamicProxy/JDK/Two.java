package com.lhj.designpatterns.proxy.dynamicProxy.JDK;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@SpringBootTest
@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
public class Two {
    @org.junit.Test
    public void test() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 2、代理类需要实现的接口数组
        Class[] interfaces = new Class[]{DataQuery.class};
        // 3、InvocationHandler
        InvocationHandler invocationHandler = new CacheInvocationHandler();

        DataQuery dataQuery = (DataQuery) Proxy.newProxyInstance(
                classLoader, interfaces, invocationHandler
        );

        // 事实上调用query方法的使用，他是调用了invoke
        String result = dataQuery.query("key1");
        System.out.println(result);
        System.out.println("--------------------");
        result = dataQuery.query("key1");
        System.out.println(result);
        System.out.println("--------------------");
        result = dataQuery.query("key2");
        System.out.println(result);
        System.out.println("++++++++++++++++++++++++++++++++++++");

        // 事实上调用queryAll方法的使用，他是调用了invoke
        result = dataQuery.queryAll("key1");
        System.out.println(result);
        System.out.println("--------------------");
        result = dataQuery.queryAll("key1");
        System.out.println(result);
        System.out.println("--------------------");
        result = dataQuery.queryAll("key2");
        System.out.println(result);
        System.out.println("--------------------");
    }
}
