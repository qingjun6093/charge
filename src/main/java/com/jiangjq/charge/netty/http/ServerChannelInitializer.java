package com.jiangjq.charge.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/11/30
 * @desc  53
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketHandler) throws Exception {
        //需要往pipeline中添加handler和http 解码器
        ChannelPipeline pipeline = socketHandler.pipeline();
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        pipeline.addLast("NettyHttpServerHandler", new NettyHttpServerHandler());
    }
}
