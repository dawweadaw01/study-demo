package com.lhj.dynamicdatasource.controller;

import com.lhj.dynamicdatasource.entity.Test;
import com.lhj.dynamicdatasource.service.TestService;
import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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

    @GetMapping(value = "/test2", produces = "application/json;charset=UTF-8")
    public void test2(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startTime,
                      @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endTime) {
        //设置时区为东八区
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = startTime.toInstant(ZoneOffset.of("+08:00")).atZone(zoneId);
        System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
