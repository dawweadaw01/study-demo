package com.lhj.designpatterns.proxy.dynamicProxy.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author banyanmei
 */

@Aspect
@Component
public class CacheAspectj {
    // 切DatabaseDataQuery
    @Pointcut("execution(* com.lhj.designpatterns.proxy.dynamicProxy.AOP.DatabaseDataQuery.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public String around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String arg = args[0].toString();
        String cache = Cache.get(arg);
        if (cache == null) {
            String result = (String) joinPoint.proceed();
            Cache.put(arg, result);
            return result;
        } else {
            System.out.println("从缓存中获取数据");
            return cache;
        }
    }
}
