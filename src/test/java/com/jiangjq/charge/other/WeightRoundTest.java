package com.jiangjq.charge.other;

import com.jiangjq.charge.ChargeApplicationTests;
import com.jiangjq.charge.entity.ServerNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/11/4
 * @desc todo
 */
public class WeightRoundTest  extends ChargeApplicationTests {

    @Test
    public void test(){
        //准备数据
        ServerNode serverNode1 = new ServerNode("192.168.0.224", 4, 0);
        ServerNode serverNode2 = new ServerNode("192.168.0.222", 2, 0);
        ServerNode serverNode3 = new ServerNode("192.168.0.221", 1, 0);
        ArrayList<ServerNode> arrayList = new ArrayList<>();
        arrayList.add(serverNode1);
        arrayList.add(serverNode2);
        arrayList.add(serverNode3);
        WeightRoundAlgorithm weightRoundRobin = new WeightRoundAlgorithm();
        weightRoundRobin.setTotalWeight(7);
        weightRoundRobin.setList(arrayList);

        //开始测试
        int requestCount = 10;//10个请求请求数
        for (int i=0;i<requestCount;i++){
            weightRoundRobin.doSelect();
        }
//        ServerNode{ip='192.168.0.224', weight=4, currWeight=-3}
//        ServerNode{ip='192.168.0.222', weight=2, currWeight=-3}
//        ServerNode{ip='192.168.0.224', weight=4, currWeight=-2}
//        ServerNode{ip='192.168.0.221', weight=1, currWeight=-3}
//        ServerNode{ip='192.168.0.224', weight=4, currWeight=-1}
//        ServerNode{ip='192.168.0.222', weight=2, currWeight=-2}
//        ServerNode{ip='192.168.0.224', weight=4, currWeight=0}
//        ServerNode{ip='192.168.0.224', weight=4, currWeight=-3}
//        ServerNode{ip='192.168.0.222', weight=2, currWeight=-3}
//        ServerNode{ip='192.168.0.224', weight=4, currWeight=-2}


    }
}
