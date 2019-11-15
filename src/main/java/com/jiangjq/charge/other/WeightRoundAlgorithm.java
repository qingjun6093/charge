package com.jiangjq.charge.other;

import com.jiangjq.charge.entity.ServerNode;


import java.util.Collections;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/11/4
 * @desc 加权轮询算法
 */
public class WeightRoundAlgorithm {

    private int totalWeight;

    private List<ServerNode> list;

    public ServerNode doSelect(){
        ServerNode tmpServerNode = null;
        for (ServerNode serverNode : list){
            if (list.size() == 0){
                return null;
            }

            serverNode.setCurrWeight(serverNode.getWeight()+serverNode.getCurrWeight());
            if (tmpServerNode ==null || tmpServerNode.getCurrWeight() < serverNode.getCurrWeight()){
                tmpServerNode = serverNode;
            }
        }
        tmpServerNode.setCurrWeight(tmpServerNode.getCurrWeight() - totalWeight);
        System.out.println(tmpServerNode.toString());
        return tmpServerNode;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public List<ServerNode> getList() {
        return list;
    }

    public void setList(List<ServerNode> list) {
        this.list = list;
    }
}
