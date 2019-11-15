package com.jiangjq.charge.entity;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/11/4
 * @desc 服务器节点
 */
public class ServerNode {
    private String ip;
    private int weight;
    private int currWeight;
    public ServerNode(String ip, int weight, int currWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currWeight = currWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCurrWeight() {
        return currWeight;
    }

    public void setCurrWeight(int currWeight) {
        this.currWeight = currWeight;
    }

    @Override
    public String toString() {
        return "ServerNode{" +
                "ip='" + ip + '\'' +
                ", weight=" + weight +
                ", currWeight=" + currWeight +
                '}';
    }
}
