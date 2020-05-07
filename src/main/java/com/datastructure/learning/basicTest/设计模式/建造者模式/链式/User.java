package com.datastructure.learning.basicTest.设计模式.建造者模式.链式;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:
 */
public class User {
    String id;
    String name;
    String password;
    String phone;

    private User(Builder builder) {
        id = builder.id;
        name = builder.name;
        password = builder.password;
        phone = builder.phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    /**
     * 静态内部类，作为辅助类
     */
    public static final class Builder {
        private String id;
        private String name;
        private String password;
        private String phone;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}