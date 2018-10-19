package com.netty.actual;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Description
 * @ClassName FirstServerHandler
 * @Author Liumh
 * @Date 2018/10/16 20:56
 * @Version v1.0
 */
@Slf4j
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("{}:服务端读取导数据：{}",new Date(), byteBuf.toString(Charset.forName("utf-8")));
        ByteBuf backMsg = getByteBuf(ctx);
        log.info("服务端回复消息");
        ctx.writeAndFlush(backMsg);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx){
        byte[] bytes = "Netty back test".getBytes();
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(bytes);
        log.info("capacity:{}", buffer.capacity());
        log.info("maxCapacity:{}", buffer.maxCapacity());
        log.info("readableBytes:{}", buffer.readableBytes());
        log.info("writableBytes:{}", buffer.writableBytes());
        buffer.markReaderIndex();
        buffer.resetReaderIndex();
        buffer.slice();
        buffer.duplicate();
        return buffer;
    }

}
