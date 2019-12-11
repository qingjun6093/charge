package com.jiangjq.charge.collection;

import com.jiangjq.charge.shgg.TreeTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
