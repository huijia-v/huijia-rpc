package com.huijia.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 处理器
 *
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/7/20 21:52
 */
public class MyChannelHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务端已经收到来自客户端的消息：--->" + byteBuf.toString(StandardCharsets.UTF_8));

        //可以通过ctx获取channel
        ctx.channel().writeAndFlush(Unpooled.copiedBuffer("ok,we have received the message from you".getBytes(StandardCharsets.UTF_8)));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //出现异常的时候执行的动作(打印并关闭通道)
        cause.printStackTrace();
        ctx.close();
    }
}
