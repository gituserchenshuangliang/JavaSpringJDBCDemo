package com.spring.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @description:spring注解
 * @author: Cherry
 * @time: 2020/6/5 10:56
 */
@Component("role")
//单例SCOPE_SINGLETON：每个Bean只生成一个实例，多例SCOPE_PROTOTYPE：每次获取Bean都会生产一个实例
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Role {
    @Value("2")
    private int id;
    @Value("法师")
    private String name;
    @Value("魔法攻击")
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
