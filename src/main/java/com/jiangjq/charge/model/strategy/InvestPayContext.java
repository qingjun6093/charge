package com.jiangjq.charge.model.strategy;

import com.jiangjq.charge.entity.Invest;

/**
 * @author jjq
 * @version 1.0
 * @date 2020/1/1
 * @desc
 */
public class InvestPayContext {

    private InvestPay investPay;

    private int payType;

    /***
     * 路由实现
     * @param payType
     */
    public InvestPayContext(int payType) {
        if (payType ==1){
            this.investPay = new BalancePay();
        }else {
            this.investPay = new PagePay();
        }

    }

    public boolean doPay(Invest invest){
        return investPay.investPay(invest);
    }

    public static void main(String[] args) {
        new InvestPayContext(0).doPay(new Invest());
    }
}
