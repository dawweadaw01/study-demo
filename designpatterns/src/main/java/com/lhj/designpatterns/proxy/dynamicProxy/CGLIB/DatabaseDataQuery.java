package com.lhj.designpatterns.proxy.dynamicProxy.CGLIB;

import org.springframework.stereotype.Component;

/**
 * @author banyanmei
 */
@Component("cglibDatabaseDataQuery")
public class DatabaseDataQuery {

    public String query(String queryKey) {
        // 他会使用数据源从数据库查询数据很慢
        System.out.println("正在从数据库查询数据");
        return "result";
    }

    public String queryAll(String queryKey) {
        // 他会使用数据源从数据库查询数据很慢
        System.out.println("正在从数据库查询数据");
        return "all result";
    }
}

