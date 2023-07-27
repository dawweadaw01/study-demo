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
public class FileResourceLoader implements IResourceLoader {
    @Override
    public Resource load(String url) {
        log.info("file");
        return new Resource(url);
    }
}
