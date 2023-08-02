package com.huijia;

import com.huijia.netty.AppClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

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

    @Test
    public void testMessage() throws IOException {

        ByteBuf message = Unpooled.buffer();
        message.writeBytes("huijia".getBytes(StandardCharsets.UTF_8));
        message.writeByte(1);
        message.writeShort(125);
        message.writeInt(256);

        // 用对象流转换为字节数据
        AppClient appClient = new AppClient();
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutput oos = new ObjectOutputStream(outputStream);
        oos.writeObject(appClient);
        byte[] bytes = outputStream.toByteArray();
        message.writeBytes(bytes);
    }

}
