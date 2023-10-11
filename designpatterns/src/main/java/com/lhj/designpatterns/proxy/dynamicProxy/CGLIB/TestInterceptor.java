package com.lhj.designpatterns.proxy.dynamicProxy.CGLIB;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description：
 * @createTime：2023-09-2315:20
 * @author：banyanmei
 */
public class TestInterceptor implements MethodInterceptor {

    private TestImpl testImpl;

    public TestInterceptor(TestImpl testImpl) {
        this.testImpl = testImpl;
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before");
         //进行远程调用得到结果
        //String result = (String) method.invoke(testImpl, args);
        String result = "tesrt";
        System.out.println("after");
        return result;
    }
}
