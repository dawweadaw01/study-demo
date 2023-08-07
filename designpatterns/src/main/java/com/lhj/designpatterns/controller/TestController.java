package com.lhj.designpatterns.controller;


import com.lhj.designpatterns.annotation.RateLimiter;
import com.lhj.designpatterns.proxy.dynamicProxy.AOP.DatabaseDataQuery;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author banyanmei
 */
@RestController
public class TestController {

    @Resource
    private DatabaseDataQuery databaseDataQuery;

    @GetMapping(value = "/test", produces = "application/json;charset=UTF-8")
    public String test(@RequestHeader("test") String test, @RequestParam("test") String test1) {
        System.out.println(test + test1);
        return test + "aa" + test1;
    }

    @GetMapping(value = "/test1", produces = "application/json;charset=UTF-8")
    @RateLimiter(value = 10, durationInSeconds = 60)
    public String testAop() {
        return databaseDataQuery.query("key1") + databaseDataQuery.queryAll("key1");
    }
}
