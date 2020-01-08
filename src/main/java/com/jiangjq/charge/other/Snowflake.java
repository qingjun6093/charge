package com.jiangjq.charge.other;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/12/18
 * @desc
 */
public class Snowflake {

    public static long id(){
        return System.currentTimeMillis()<<22<<10|5<<12|1;
    }
}
