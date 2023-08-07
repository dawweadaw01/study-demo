package com.lhj.dynamicdatasource.controller;

import com.lhj.dynamicdatasource.entity.Test;
import com.lhj.dynamicdatasource.service.TestService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author banyanmei
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping(value = "/test", produces = "application/json;charset=UTF-8")
    public Test test(Integer id) {
        return testService.getTestById(id);
    }
}
