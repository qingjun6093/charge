package com.jiangjq.charge.other;

import com.github.snksoft.crc.CRC;
import org.junit.Test;
import sun.misc.CRC16;

/**
 * @author jiangjunqing
 * @date 2020/1/8
 * @desc
 */
public class CRCTest {


    @Test
    public void crc16(){
        //CRC.Parameters.CRC16;
        long crc = CRC.calculateCRC(CRC.Parameters.CRC16, "hello".getBytes());
        System.out.println(crc);
    }

}
