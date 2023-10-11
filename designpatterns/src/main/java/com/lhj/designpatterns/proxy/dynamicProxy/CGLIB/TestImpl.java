package com.lhj.designpatterns.proxy.dynamicProxy.CGLIB;

/**
 * @description：
 * @createTime：2023-09-2315:10
 * @author：banyanmei
 */
public class TestImpl implements Test{
    @Override
    public String test() {
        System.out.println("test");
        return "test";
    }
}
