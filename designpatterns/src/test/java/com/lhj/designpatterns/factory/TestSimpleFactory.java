package com.lhj.designpatterns.factory;

import com.lhj.designpatterns.entity.Resource;
import com.lhj.designpatterns.factoryMethod.simplefactory.SFResourceLoader;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 简单工厂模式
 * 优点：简单，易于理解
 * 缺点：不符合开闭原则，每次新增类型都需要修改工厂类
 * @author banyanmei
 * @create 2020-06-04
 */
@SpringBootTest
@Slf4j
public class TestSimpleFactory {
    @Autowired
    private SFResourceLoader SFResourceLoader;
    @Test
    void testSimpleFactory1() {
        Resource load = SFResourceLoader.load("classpath://www.baidu.com");
        log.info(load.toString());
    }
}
