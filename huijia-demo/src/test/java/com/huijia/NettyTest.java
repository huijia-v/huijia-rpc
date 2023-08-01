package com.huijia;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

/**
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/8/1 22:31
 */
public class NettyTest {

    @Test
    public void testByteBuf() {
        ByteBuf byteBuf = Unpooled.buffer();
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
    }

    @Test
    public void testCompositeByteBuf() {
        ByteBuf header = Unpooled.buffer();
        ByteBuf body = Unpooled.buffer();

        //通过逻辑组装，而不是物理拷贝，实现jvm中的零拷贝
        CompositeByteBuf byteBufs = Unpooled.compositeBuffer();
        byteBufs.addComponents(header, body);

    }

    @Test
    public void testWrapper() {
        byte[] buf = new byte[1024];
        byte[] buy2 = new byte[1024];
        //共享byte数组的内容，而不是拷贝，这样也算是零拷贝
        ByteBuf byteBuf = Unpooled.wrappedBuffer(buf, buy2);


    }

}
