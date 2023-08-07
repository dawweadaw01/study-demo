package com.lhj.designpatterns.Builder;

/**
 * @author banyanmei
 * 建造者设计模式
 * 1. 用于创建复杂对象
 * 2. 与工厂模式的区别：工厂模式关注的是创建单个对象，而建造者模式关注的是创建复杂对象
 * 3. 与抽象工厂模式的区别：抽象工厂模式关注的是创建一系列相关对象，而建造者模式关注的是创建复杂对象
 * 4. 可以进行链式调用
 */
public class HtmlDocument {
    private String header = "";
    private String body = "";
    private String footer = "";

    public void addHeader(String header) {
        this.header = header;
    }

    public void addBody(String body) {
        this.body = body;
    }

    public void addFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "<html><head>" + header + "</head><body>" + body + "</body><footer>" + footer + "</footer></html>";
    }

    public static class Builder {
        protected HtmlDocument document;

        public Builder() {
            document = new HtmlDocument();
        }

        public Builder addHeader(String header) {
            document.addHeader(header);
            return this;
        }

        public Builder addBody(String body) {
            document.addBody(body);
            return this;
        }

        public Builder addFooter(String footer) {
            document.addFooter(footer);
            return this;
        }

        public HtmlDocument build() {
            return document;
        }
    }
}

