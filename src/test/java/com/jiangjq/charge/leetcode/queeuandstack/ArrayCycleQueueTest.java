package com.jiangjq.charge.leetcode.queeuandstack;

import com.jiangjq.charge.ChargeApplicationTests;

import com.jiangjq.charge.leetcode.queueandstack.ArrayCycleQueue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jiangjunqing
 * @date 2019/6/19
 * @desc
 */
public class ArrayCycleQueueTest extends ChargeApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(ArrayCycleQueueTest.class);

    @Test
    public void test1(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        int[] data = arrayCycleQueue.getData();
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:-1,tail:-1
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
             //data[0]:0  data[1]:0 data[2]:0 data[3]:0 data[4]:0
        }
    }

    @Test
    public void test2(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        arrayCycleQueue.enqueue(13);
        arrayCycleQueue.enqueue(21);
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:0,tail:1
        int[] data = arrayCycleQueue.getData();
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
            //data[0]:13  data[1]:21 data[2]:0 data[3]:0 data[4]:0
        }
    }

    @Test
    public void test3(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        arrayCycleQueue.enqueue(13);
        arrayCycleQueue.enqueue(21);
        arrayCycleQueue.enqueue(27);
        arrayCycleQueue.enqueue(35);
        arrayCycleQueue.enqueue(5);
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:0,tail:4
        int[] data = arrayCycleQueue.getData();
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
            //data[0]:13  data[1]:21 data[2]:27 data[3]:35 data[4]:5
        }
    }

    @Test
    public void test4(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        arrayCycleQueue.enqueue(13);
        arrayCycleQueue.enqueue(21);
        arrayCycleQueue.enqueue(27);
        arrayCycleQueue.enqueue(35);
        arrayCycleQueue.enqueue(5);
        //队列已满,10插入不成功
        arrayCycleQueue.enqueue(10);
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:0,tail:4
        int[] data = arrayCycleQueue.getData();
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
            //data[0]:13  data[1]:21 data[2]:27 data[3]:35 data[4]:5
        }
    }

    @Test
    public void test5(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        arrayCycleQueue.enqueue(13);
        arrayCycleQueue.enqueue(21);
        arrayCycleQueue.enqueue(27);
        arrayCycleQueue.enqueue(35);
        arrayCycleQueue.enqueue(5);
        //出队:出队只是指针的移动,数据还是存在
        arrayCycleQueue.dequeue();
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:1,tail:4
        int[] data = arrayCycleQueue.getData();
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
            //data[0]:13  data[1]:21 data[2]:27 data[3]:35 data[4]:5
        }
    }

    @Test
    public void test6(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        arrayCycleQueue.enqueue(13);
        arrayCycleQueue.enqueue(21);
        arrayCycleQueue.enqueue(27);
        arrayCycleQueue.enqueue(35);
        arrayCycleQueue.enqueue(5);
        //出队:出队只是指针的移动,数据还是存在
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:3,tail:4
        int[] data = arrayCycleQueue.getData();
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
            //data[0]:13  data[1]:21 data[2]:27 data[3]:35 data[4]:5
        }
    }

    @Test
    public void test7(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        arrayCycleQueue.enqueue(13);
        arrayCycleQueue.enqueue(21);
        arrayCycleQueue.enqueue(27);
        arrayCycleQueue.enqueue(35);
        arrayCycleQueue.enqueue(5);
        //出队:出队只是指针的移动,数据还是存在
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:-1,tail:-1
        int[] data = arrayCycleQueue.getData();
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
            //data[0]:13  data[1]:21 data[2]:27 data[3]:35 data[4]:5
        }
    }

    @Test
    public void test8(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        arrayCycleQueue.enqueue(13);
        arrayCycleQueue.enqueue(21);
        arrayCycleQueue.enqueue(27);
        arrayCycleQueue.enqueue(35);
        arrayCycleQueue.enqueue(5);
        //出队:出队只是指针的移动,数据还是存在
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        //head:3,tail:4
        //data[0]:13  data[1]:21 data[2]:27 data[3]:35 data[4]:5

        arrayCycleQueue.enqueue(100);
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:3,tail:0
        int[] data = arrayCycleQueue.getData();
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
            //data[0]:100  data[1]:21 data[2]:27 data[3]:35 data[4]:5
        }
    }

    @Test
    public void test9(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        arrayCycleQueue.enqueue(13);
        arrayCycleQueue.enqueue(21);
        arrayCycleQueue.enqueue(27);
        arrayCycleQueue.enqueue(35);
        arrayCycleQueue.enqueue(5);
        //出队:出队只是指针的移动,数据还是存在
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        //head:3,tail:4
        //data[0]:13  data[1]:21 data[2]:27 data[3]:35 data[4]:5

        arrayCycleQueue.enqueue(100);
        arrayCycleQueue.enqueue(101);
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:3,tail:1
        int[] data = arrayCycleQueue.getData();
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
            //data[0]:100  data[1]:101 data[2]:27 data[3]:35 data[4]:5
        }
    }

    @Test
    public void test10(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        arrayCycleQueue.enqueue(13);
        arrayCycleQueue.enqueue(21);
        arrayCycleQueue.enqueue(27);
        arrayCycleQueue.enqueue(35);
        arrayCycleQueue.enqueue(5);
        //出队:出队只是指针的移动,数据还是存在
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        //head:3,tail:4
        //data[0]:13  data[1]:21 data[2]:27 data[3]:35 data[4]:5

        arrayCycleQueue.enqueue(100);
        arrayCycleQueue.enqueue(101);
        arrayCycleQueue.enqueue(102);
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:3,tail:2
        int[] data = arrayCycleQueue.getData();
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
            //data[0]:100  data[1]:101 data[2]:102 data[3]:35 data[4]:5
        }
    }

    @Test
    public void test11(){
        ArrayCycleQueue arrayCycleQueue = new ArrayCycleQueue(5);
        arrayCycleQueue.enqueue(13);
        arrayCycleQueue.enqueue(21);
        arrayCycleQueue.enqueue(27);
        arrayCycleQueue.enqueue(35);
        arrayCycleQueue.enqueue(5);
        //出队:出队只是指针的移动,数据还是存在
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        arrayCycleQueue.dequeue();
        //head:3,tail:4
        //data[0]:13  data[1]:21 data[2]:27 data[3]:35 data[4]:5

        arrayCycleQueue.enqueue(100);
        arrayCycleQueue.enqueue(101);
        arrayCycleQueue.enqueue(102);
        //队列已满,103插入不进去
        arrayCycleQueue.enqueue(103);
        logger.info("head:{},tail:{}", arrayCycleQueue.getHead(), arrayCycleQueue.getTail());
        //head:3,tail:2
        int[] data = arrayCycleQueue.getData();
        for (int i = 0;i<data.length;i++){
            logger.info("data[{}]:{}",i,data[i]);
            //data[0]:100  data[1]:101 data[2]:102 data[3]:35 data[4]:5
        }
    }
}
