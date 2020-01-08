package com.jiangjq.charge.model.strategy;

import com.jiangjq.charge.entity.Invest;

/**
 * @author jjq
 * @version 1.0
 * @date 2020/1/1
 * @desc todo
 */
public class PagePay implements InvestPay {
    @Override
    public boolean investPay(Invest invest) {
        System.out.println("PagePay");
        return false;
    }
}
