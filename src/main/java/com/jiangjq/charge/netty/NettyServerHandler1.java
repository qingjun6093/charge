package com.jiangjq.charge.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/11/30
 * @desc
 */
public class NettyServerHandler1 extends ChannelInboundHandlerAdapter {


    /**
     *ctx是一个上下文大对象,主要包含"
     * 1.handler,就是this
     * 2.pipeline,包含了pipeline,next和tail
     * 3.next和prev
     * 4.等等其他的
     *
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //System.out.println("NettyServerHandler1ThreadName:" + Thread.currentThread().getName());
        //ctx.writeAndFlush(Unpooled.copiedBuffer("你来啦!", CharsetUtil.UTF_8));

        //处理耗时任务:会提交channel到NioEventLoop的taskQueue中去
        //提交给eventLoop中去执行
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("(耗时)你来啦!\n", CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("channelRead...");

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("(正常)你来啦!", CharsetUtil.UTF_8));
    }

    /**
     * 发生异常,关闭通道
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
