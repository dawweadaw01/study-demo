package com.lhj.designpatterns.factoryMethod.simplefactory;

import com.lhj.designpatterns.entity.Resource;
import lombok.extern.slf4j.Slf4j;

/**
 * @author banyanmei
 * 简单工厂模式
 * 优点：简单，易于理解
 * 缺点：不符合开闭原则，每次新增类型都需要修改工厂类
 */
@Slf4j
public class ResourceFactory {

    public static Resource create(String type, String url) {
        if ("http".equals(type)) {
            // ..发起请求下载资源... 可能很复杂
            log.info("http");
            return new Resource(url);
        } else if ("file".equals(type)) {
            // ..建立流，做异常处理等等
            log.info("file");
            return new Resource(url);
        } else if ("classpath".equals(type)) {
            // ...
            log.info("classpath");
            return new Resource(url);
        } else {
            log.info("default");
            return new Resource("default");
        }
    }
}
