package com.lhj.designpatterns.exception;

/**
 * @author banyanmei
 * 处理异常类
 */
public class ResourceLoadException extends RuntimeException {

    public ResourceLoadException() {
        super("加载资源是发生问题。");
    }

    public ResourceLoadException(String message) {
        super(message);
    }
}
