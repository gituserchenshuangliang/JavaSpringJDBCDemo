package com.mybatis.entity;

import java.io.Serializable;

/**
 * Entity
 * @author Cherry
 * 2020年5月28日
 */
public class Teacher implements Serializable {
    private int uuid;
    private String name;
    private int age;
    private String major;
    private String sex;
    private double salary;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher() {
    }

    public Teacher(int uuid) {
        this.uuid = uuid;
    }

    public Teacher(String name, int age, String major, String sex, double salary) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.sex = sex;
        this.salary = salary;
    }

    public Teacher(int uuid, String name, int age, String major, String sex, double salary) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
        this.major = major;
        this.sex = sex;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", sex=" + sex +
                ", salary=" + salary +
                '}';
    }
}
