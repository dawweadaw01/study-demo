package com.lhj.designpatterns.proxy.dynamicProxy.AOP;

import com.lhj.designpatterns.annotation.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author banyanmei
 */

@Component
@Aspect
@Order(1)
public class RateLimiterAspect {
    // 用于存储令牌桶
    private final java.util.Map<String, com.google.common.util.concurrent.RateLimiter> rateLimiters
            = new java.util.concurrent.ConcurrentHashMap<>(256);

    @Pointcut("@annotation(rateLimiter)")
    public void pointcut(RateLimiter rateLimiter) {
    }

    @Around("pointcut(rateLimiter)")
    public Object around(ProceedingJoinPoint joinPoint, RateLimiter rateLimiter) throws Throwable {

        // 获取注解上的参数
        int permits = rateLimiter.value();
        int durationInSeconds = rateLimiter.durationInSeconds();
        String key = joinPoint.getSignature().toString();
        com.google.common.util.concurrent.RateLimiter rateLimiter1 = rateLimiters.computeIfAbsent
                (key, k -> com.google.common.util.concurrent.RateLimiter.create((double) permits / durationInSeconds));

        // 尝试获取令牌，如果获取到则执行方法，否则抛出异常
        if (rateLimiter1.tryAcquire()) {
            return joinPoint.proceed();
        } else {
            throw new RuntimeException("Rate limit exceeded.");
        }
    }
}
