package com.lhj.designpatterns.proxy.dynamicProxy.AOP;

public interface DataQuery {
    String query(String queryKey);

    String queryAll(String queryKey);
}

