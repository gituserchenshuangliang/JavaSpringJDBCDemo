package com.mybatis.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @description:entity
 * @author: Cherry
 * @time: 2020/6/3 15:13
 */
public class ClassRoom implements Serializable {
    private int uuid;
    private String name;
    private Teacher teacher;
    private ArrayList<Student> list;

    @Override
    public String toString() {
        return "ClassRoom{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", list=" + list +
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

    public ClassRoom() {
    }

    public ClassRoom(int uuid) {
        this.uuid = uuid;
    }
}
