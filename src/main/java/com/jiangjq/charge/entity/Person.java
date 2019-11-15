package com.jiangjq.charge.entity;

import java.util.Objects;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/10/19
 * @desc  define person class
 */
public class Person {

    private String name;

    private Integer level;

    public Person(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(level, person.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
