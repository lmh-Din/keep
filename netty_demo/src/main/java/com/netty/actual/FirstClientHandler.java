package com.netty.actual;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Description
 * @ClassName FirstChannelHandler
 * @Author Liumh
 * @Date 2018/10/16 19:47
 * @Version v1.0
 */
@Slf4j
public class FirstClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("{}：客户端写出（发送）数据", new Date());
        ByteBuf msg = getByteBuf(ctx);
        ctx.channel().writeAndFlush(msg);
    }

    public ByteBuf getByteBuf(ChannelHandlerContext ctx){
        //获取二进制抽象 byteBuf
        ByteBuf byteBuf = ctx.alloc().buffer();
        //准备数据，指定字符集为UTF-8
        String msg = "Netty test...";
        byte[] bytes = msg.getBytes(Charset.forName("utf-8"));
        //填充数据到byteBuf
        byteBuf = byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buffer = (ByteBuf) msg;
        log.info("客户端接收服务端消息：{}", buffer.toString(Charset.forName("utf-8")));
    }
}
