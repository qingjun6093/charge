package com.jiangjq.charge.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInboundInvoker;
import io.netty.util.CharsetUtil;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/11/30
 * @desc todo
 */
public class NettyClientHandler1 extends ChannelInboundHandlerAdapter {

    /**
     * 客户端激活事件
     * @param channelHandlerContext
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println("NettyClientHandler1:" + Thread.currentThread().getName());
        channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer("客户端:嘻嘻我来了", CharsetUtil.UTF_8));

    }

    /**
     * 客户端接收消息事件
     * @param channelHandlerContext
     * @param o
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        ByteBuf msg= (ByteBuf)o;
        System.out.println("来自服务器的回复:" + msg.toString(CharsetUtil.UTF_8));
    }


}
