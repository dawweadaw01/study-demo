package com.lhj.designpatterns.proxy.dynamicProxy.AOP;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author banyanmei
 */
public class Cache {
    private final static Map<String, String> cache = new ConcurrentHashMap<>(256);

    public static String get(String key) {
        return cache.get(key);
    }

    public static void put(String key, String value) {
        cache.put(key, value);
    }

}
