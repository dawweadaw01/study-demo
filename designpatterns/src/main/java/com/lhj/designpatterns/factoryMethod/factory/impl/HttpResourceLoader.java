package com.lhj.designpatterns.factoryMethod.factory.impl;

import com.lhj.designpatterns.factoryMethod.factory.IResourceLoader;
import com.lhj.designpatterns.entity.Resource;
import lombok.extern.slf4j.Slf4j;

/**
 * @author banyanmei
 * 工厂模式的实现类
 *
 */
@Slf4j
public class HttpResourceLoader implements IResourceLoader {
    @Override
    public Resource load(String url) {
        log.info("http");
        return new Resource(url);
    }
}
