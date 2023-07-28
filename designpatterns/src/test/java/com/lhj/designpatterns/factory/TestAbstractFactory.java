package com.lhj.designpatterns.factory;

import com.lhj.designpatterns.factory.abstractFactoryMethod.AbstractFResourceLoader;
import com.lhj.designpatterns.factory.abstractFactoryMethod.product.AbstractResource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestAbstractFactory {

    @Autowired
    private AbstractFResourceLoader abstractFResourceLoader;
    @Test
    void testAbstractFactory() {
        String url = "file://www.baidu.com";
        AbstractResource load = abstractFResourceLoader.load(url);
        log.info(load.toString());
        load.load();
    }
}
