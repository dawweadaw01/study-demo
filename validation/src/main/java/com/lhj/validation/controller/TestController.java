package com.lhj.validation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author banyanmei
 */
@RestController
@Slf4j
public class TestController {
    @PostMapping("/test")
    public String test() {
        return "test";
    }
}
