package com.lhj.designpatterns.proxy.dynamicProxy.CGLIB;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;

@SpringBootTest
@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
public class Test {
    @org.junit.Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DatabaseDataQuery.class);
        enhancer.setCallback(new CacheMethodInterceptor(new DatabaseDataQuery()));
        //cglib可以代理任何的类，不一定是接口
        DatabaseDataQuery databaseDataQuery = (DatabaseDataQuery) enhancer.create();
        String query = databaseDataQuery.query("key1");
        String query1 = databaseDataQuery.query("key1");
        String query2 = databaseDataQuery.query("key2");
    }
}
