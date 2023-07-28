package com.lhj.designpatterns.factory.abstractFactoryMethod.factory.impl;

import com.lhj.designpatterns.factory.abstractFactoryMethod.factory.IResourceLoader;
import com.lhj.designpatterns.factory.abstractFactoryMethod.product.AbstractResource;
import com.lhj.designpatterns.factory.abstractFactoryMethod.product.impl.HttpResource;
import lombok.extern.slf4j.Slf4j;

/**
 * @author banyanmei
 * 工厂模式的实现类
 */
@Slf4j
public class HttpResourceLoader implements IResourceLoader {

    @Override
    public AbstractResource load(String url) {
        return new HttpResource(url);
    }
}
