package com.lhj.designpatterns.Builder;

/**
 * @author banyanmei
 * 建造者设计模式
 * 不可变对象,通过内部类来进行创建
 */
public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final String address;

    private ImmutablePerson(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private String name;
        private int age;
        private String address;

        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public ImmutablePerson build() {
            return new ImmutablePerson(this);
        }
    }
}
