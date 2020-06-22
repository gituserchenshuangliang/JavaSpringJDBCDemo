package com.mybatis.entity;

import com.mybatis.typehandle.SexEnum;

import java.io.Serializable;

/**
 * Entity
 * @author Cherry
 * 2020年5月28日
 */
public class Student implements Serializable {
    private int uuid;
    private String name;
    private SexEnum sex;
    private int classUuid;

    public Student() {
    }

    public Student(int uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", classUuid=" + classUuid +
                '}';
    }

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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public int getClassUuid() {
        return classUuid;
    }

    public void setClassUuid(int classUuid) {
        this.classUuid = classUuid;
    }
}
