package com.lhj.designpatterns.factoryMethod.factory;

import com.lhj.designpatterns.entity.Resource;

/**
 * @author banyanmei
 * 抽象工厂模式
 * 优点：符合开闭原则，新增类型只需要新增工厂类和资源类即可
 * 缺点：每次新增类型都需要新增工厂类和资源类
 */
public interface IResourceLoader {
    Resource load(String url);
}
