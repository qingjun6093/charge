package com.jiangjq.charge.model.strategy;

import com.jiangjq.charge.entity.Invest;

/**
 * @author jjq
 * @version 1.0
 * @date 2020/1/1
 * @desc
 */
public interface InvestPay {
    boolean investPay(Invest invest);
}
