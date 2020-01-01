package com.jiangjq.charge.model.strategy;

import com.jiangjq.charge.entity.Invest;

/**
 * @author jjq
 * @version 1.0
 * @date 2020/1/1
 * @desc
 */
public class BalancePay implements InvestPay {
    @Override
    public boolean investPay(Invest invest) {
        System.out.println("BalancePay");
        return false;
    }
}
