package com.jiangjq.charge.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/11/30
 * @desc
 */
public class NettyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    /**
     *
     * @param ctx
     * @param msg 客户端和服务器端相互通讯的数据
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        System.out.println("HttpObject:"+ msg);
        if (msg instanceof HttpRequest){
            //HttpRequest httpRequest = (HttpRequest)msg;
            //String s = httpRequest.headers().get(HttpHeaderNames.ACCEPT);
            ByteBuf byteBuf = Unpooled.copiedBuffer("你来啦", CharsetUtil.UTF_8);
            //构造http返回体
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=utf-8");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());
            //返回
            ctx.writeAndFlush(response);
        }
    }
}
