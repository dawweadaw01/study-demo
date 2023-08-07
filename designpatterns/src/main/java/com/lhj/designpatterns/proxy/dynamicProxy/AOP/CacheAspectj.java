package com.lhj.designpatterns.proxy.dynamicProxy.AOP;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author banyanmei
 */

@Aspect
@Component
@Order(2)
public class CacheAspectj {
    // 切DatabaseDataQuery
    @Pointcut("execution(* com.lhj.designpatterns.proxy.dynamicProxy.AOP.DatabaseDataQuery.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public String around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 通过spring得到request对象
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        //拿到ip
        String ip = request.getRemoteAddr();
        //拿到url
        String url = request.getRequestURL().toString();
        Object[] args = joinPoint.getArgs();
        //拿到方法名称
        String method = joinPoint.getSignature().toString();
        String key = url + method + Arrays.toString(args);
        String cache = Cache.get(key);
        if (cache == null) {
            String result = (String) joinPoint.proceed();
            Cache.put(key, result);
            return result;
        } else {
            System.out.println("从缓存中获取数据");
            return cache;
        }
    }
}
