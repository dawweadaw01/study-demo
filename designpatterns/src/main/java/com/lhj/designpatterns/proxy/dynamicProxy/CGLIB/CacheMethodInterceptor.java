package com.lhj.designpatterns.proxy.dynamicProxy.CGLIB;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author banyanmei
 */
public class CacheMethodInterceptor implements MethodInterceptor {
    private DatabaseDataQuery databaseDataQuery;

    private final HashMap<String, String> cache = new LinkedHashMap<>(256);


    public CacheMethodInterceptor(DatabaseDataQuery databaseDataQuery) {
        this.databaseDataQuery = databaseDataQuery;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String result = null;
        if ("query".equals(method.getName())) {
            result = cache.get(args[0].toString());
            if (result != null) {
                System.out.println("数据从缓存重获取。");
                return result;
            }
            result = (String) method.invoke(databaseDataQuery, args);
            cache.put(args[0].toString(), result);
            return result;
        }
        return method.invoke(databaseDataQuery, args).toString();
    }
}
