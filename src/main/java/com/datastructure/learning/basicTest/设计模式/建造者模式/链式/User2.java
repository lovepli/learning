package com.datastructure.learning.basicTest.设计模式.建造者模式.链式;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:  最简单的链式结构： set()方法返回当前对象
 */
public class User2 {

    private String id;
    private String name;
    private String password;
    private String phone;

    public String getId() {
        return id;
    }

    public User2 setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User2 setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User2 setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User2 setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return "User2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static void main(String[] args) {
        User2 user2=new User2()
                .setId("001")
                .setName("张三")
                .setPassword("123456")
                .setPhone("110");

        System.out.println(user2);

    }
}
