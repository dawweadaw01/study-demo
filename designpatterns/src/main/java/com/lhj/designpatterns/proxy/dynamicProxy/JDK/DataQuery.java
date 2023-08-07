package com.lhj.designpatterns.proxy.dynamicProxy.JDK;

public interface DataQuery {
    String query(String queryKey);

    String queryAll(String queryKey);
}

