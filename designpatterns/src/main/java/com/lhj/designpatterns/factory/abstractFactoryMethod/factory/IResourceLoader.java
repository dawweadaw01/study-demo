package com.lhj.designpatterns.factory.abstractFactoryMethod.factory;

import com.lhj.designpatterns.entity.Resource;
import com.lhj.designpatterns.factory.abstractFactoryMethod.product.AbstractResource;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author banyanmei
 * 抽象工厂模式
 * 优点：符合开闭原则，新增类型只需要新增工厂类和资源类即可
 * 缺点：每次新增类型都需要新增工厂类和资源类
 * 产品的生成逻辑写在抽象工厂的实现类中
 */
public interface IResourceLoader {
    AbstractResource load(String url);

}
