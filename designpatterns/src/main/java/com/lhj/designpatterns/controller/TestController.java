package com.lhj.designpatterns.controller;


import org.springframework.web.bind.annotation.*;

/**
 * @author banyanmei
 */
@RestController
public class TestController {
    @GetMapping(value = "/test", produces = "application/json;charset=UTF-8")
    public String test(@RequestHeader("test") String test, @RequestParam("test") String test1) {
        System.out.println(test + test1);
        return test + "aa" + test1;
    }
}
