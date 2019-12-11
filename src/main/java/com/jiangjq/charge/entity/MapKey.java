package com.jiangjq.charge.entity;

import java.util.Objects;

/**
 * @author jiangjunqing
 * @date 2019/12/11
 * @desc
 */
public class MapKey {
    String name;

    public MapKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        MapKey mapKey = (MapKey) o;
        return Objects.equals(name, mapKey.name);
    }

    @Override
    public int hashCode() {
        return "shu17u".hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
