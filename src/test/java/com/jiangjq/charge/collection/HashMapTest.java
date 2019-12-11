package com.jiangjq.charge.collection;

import com.jiangjq.charge.entity.MapKey;
import com.jiangjq.charge.shgg.TreeTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jiangjunqing
 * @date 2019/12/11
 * @desc
 */
public class HashMapTest {
    private static Logger logger = LoggerFactory.getLogger(TreeTest.class);

    @Test
    public void test(){
        String key = "shu17u";
        //int hash = key.hashCode();
        int hash = -903034273;
        int index = hash & 15;
        int index2 = hash & 31;
        logger.info("hash:{},index:{},index2:{}", hash, index, index2);
        //hash:-903034273,index:15,index2:31

    }

    /**
     * 设置为true,key1将排在最后
     */
    @Test
    public void afterNodeAccess(){
        LinkedHashMap<String, String> map = new LinkedHashMap<>(16,0.75f,true);
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        map.put("key5","value5");
        map.put("key1","value11");

        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey()+"=>"+entry.getValue());
        }
    }

    @Test
    public void afterNodeAccess2(){
        HashMap<MapKey, String> map = new HashMap<>(64);
        MapKey key1 = new MapKey("key1");
        map.put(key1,"value1");
        logger.info("hash1:{}", key1.hashCode());
        MapKey key2 = new MapKey("key2");
        logger.info("hash2:{}", key2.hashCode());
        map.put(key2,"value2");
        map.put(new MapKey("key3"),"value3");
        map.put(new MapKey("key4"),"value4");
        map.put(new MapKey("key5"),"value5");
        map.put(new MapKey("key1"),"value11");
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey().toString()+"=>"+entry.getValue());
        }
    }
}
