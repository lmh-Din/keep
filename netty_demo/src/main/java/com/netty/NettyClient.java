package com.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @ClassName NettyClient
 * @Author Liumh
 * @Date 2018/10/10 19:55
 * @Version v1.0
 */
public class NettyClient {

    //重试连接最大次数
    private static final int MAX_RETRY = 3;

    public static void main(String[] args){
        //客户端引导类（负责启动客户端以及连接服务端、与服务端引导类：ServerBootstrap对应）
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new StringEncoder());
                    }
                });
        validConnect(bootstrap, "127.0.0.1", 8000, 0);
        Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();
        while (true){
            channel.writeAndFlush(new Date() + "Hello Netty");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void validConnect(Bootstrap bootstrap, String ipAddr, int port, int retry){
        ChannelFuture future = bootstrap.connect(ipAddr, port);
        future.addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()){
                    System.out.println("连接成功");
                }else if (MAX_RETRY == retry){
                    System.err.println("重试次数达到上限");
                    System.exit(0);
                }else {
                    int delay = 1 << retry;
                    System.out.println("连接失败，"+delay+"秒后重新连接");
                    bootstrap.config().group().schedule(new Runnable() {
                        @Override
                        public void run() {
                            validConnect(bootstrap, ipAddr, port, retry+1);
                        }
                    }, delay, TimeUnit.SECONDS);

                }
            }
        });
    }
}
