package com.lhj.designpatterns.factory.abstractFactoryMethod;

import com.lhj.designpatterns.exception.ResourceLoadException;
import com.lhj.designpatterns.factory.abstractFactoryMethod.factory.IResourceLoader;
import com.lhj.designpatterns.factory.abstractFactoryMethod.product.AbstractResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author banyanmei
 */

/**
 * @author banyanmei
 * @create 2019-10-27
 */
@Component
public class AbstractFResourceLoader {

    private static final Map<String, IResourceLoader> RESOURCE_LOADER_MAP = new HashMap<>();

    //版本2
//    static {
//        resourceLoaderMap.put("http", new HttpResourceLoader());
//        resourceLoaderMap.put("classpath", new ClassPathResourceLoader());
//        resourceLoaderMap.put("file", new FileResourceLoader());
//    }
    //版本3
    static {

        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("abstractfresourceloader.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            //拿到类名，通过反射创建对象，然后放到集合中
            for (Object key : properties.keySet()) {
                String className = properties.getProperty(key.toString());
                Class<?> clazz = Class.forName(className);
                IResourceLoader resourceLoader = (IResourceLoader) clazz.getConstructor().newInstance();
                RESOURCE_LOADER_MAP.put(key.toString(), resourceLoader);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public AbstractResource load(String url) {
        String prefix = getPrefix(url);
        //版本1
//        IResourceLoader resourceLoader;
//        if ("http".equals(prefix)) {
//            resourceLoader = new HttpResourceLoader();
//        } else if ("classpath".equals(prefix)) {
//            resourceLoader = new ClassPathResourceLoader();
//        } else if ("file".equals(prefix)) {
//            resourceLoader = new FileResourceLoader();
//        } else {
//            throw new ResourceLoadException("不支持的资源类型");
//        }
//        //加一个工厂就要加一个ifesle
//        return resourceLoader.load(url);
        //版本2
        try {
            return RESOURCE_LOADER_MAP.get(prefix).load(url);
        } catch (Exception e) {
            throw new ResourceLoadException("不支持的资源类型");
        }
    }

    public String getPrefix(String url) {
        if (url == null || !url.contains(":")) {
            throw new ResourceLoadException("url不能为空");
        }
        return url.substring(0, url.indexOf(":"));
    }

}





