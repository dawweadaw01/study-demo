package com.lhj.designpatterns.proxy.dynamicProxy.AOP;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
public class Two {

    @Autowired
    private DatabaseDataQuery databaseDataQuery;

    @org.junit.Test
    public void test() {
        String query = databaseDataQuery.query("key1");
        String query1 = databaseDataQuery.query("key1");
        String query2 = databaseDataQuery.query("key2");
    }
}
