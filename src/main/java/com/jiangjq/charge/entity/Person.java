package com.jiangjq.charge.entity;

import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/10/19
 * @desc  define person class
 */
public class Person implements Comparable<Person>{

    private String name;

    private Integer level;

    public Person(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(level, person.level);
    }

    /**
     * 定义person的大小比较标准:
     * 1.level大person的大
     * 2.level相等,name首字母靠前的大,首字母相同,比较第二个字母,依次类推
     * 2.只有level和name都相等,才视为同一个person
     * @param o other person
     * @return
     */
    @Override
    public int compareTo(Person o) {
        if (this.level > o.level){
            return 1;
        }else if (this.level < o.level){
            return -1;
        }else {
            if (this.name.equals(o.name)){
                return 0;
            }
            return this.name.compareTo(o.name);
        }
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
