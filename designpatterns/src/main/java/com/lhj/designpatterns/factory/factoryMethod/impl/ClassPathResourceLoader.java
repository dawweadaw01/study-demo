package com.lhj.designpatterns.factory.factoryMethod.impl;

import com.lhj.designpatterns.entity.Resource;
import com.lhj.designpatterns.factory.factoryMethod.IResourceLoader;
import lombok.extern.slf4j.Slf4j;

/**
 * @author banyanmei
 * 工厂模式的实现类
 */
@Slf4j
public class ClassPathResourceLoader implements IResourceLoader {
    @Override
    public Resource load(String url) {
        log.info("classpath");
        return new Resource(url);
    }
}
