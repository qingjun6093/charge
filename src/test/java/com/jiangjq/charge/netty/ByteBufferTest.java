package com.jiangjq.charge.netty;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * @author jiangjunqing
 * @date 2019/12/6
 * @desc
 */
public class ByteBufferTest {
    private static Logger logger = LoggerFactory.getLogger(ByteBufferTest.class);

    @Test
    public void newByteBuffer(){
        String s = "hello,world";
        byte[] bytes = s.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        ByteBuffer put = byteBuffer.put(bytes);
        for (int i=0;i<bytes.length;i++){
            byte b = put.get(i);
            logger.info("i:{},b:{}", i, b);
        }
    }

    @Test
    public void writeFile() throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(new File("'D:\\bytebuffer.txt"));
    }
}
