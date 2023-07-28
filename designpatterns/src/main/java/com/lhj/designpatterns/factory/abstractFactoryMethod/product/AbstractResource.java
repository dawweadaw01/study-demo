package com.lhj.designpatterns.factory.abstractFactoryMethod.product;

/**
 * @author banyanmei
 */
public abstract class AbstractResource {
    private String url;

    public AbstractResource() {
    }

    public AbstractResource(String url) {
        this.url = url;
    }

    protected void shardMethod(String url) {
        System.out.println("shardMethod" + url);
    }

    public abstract void load();

    @Override
    public String toString() {
        return "AbstractResource{" +
                "url='" + url + '\'' +
                '}';
    }
}
