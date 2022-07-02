package com.User;

public class User {
    String name;//姓名
    String sex;//性别
    String num;//电话号码

    public User(String name, String sex, String num) {
        this.name = name;
        this.sex = sex;
        this.num = num;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getNum() {
        return num;
    }

    public void setName(String name) {
        System.out.println(52415241);
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setNum(String num) {
        this.num = num;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
