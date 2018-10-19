package com.netty.actual;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;

/**
 * @Description 实战——客户端和服务端双向通信
 * @ClassName actual
 * @Author Liumh
 * @Date 2018/10/16 19:30
 * @Version v1.0
 */
public class ActualNettyClient {

    public static void main(String[] args){
        //创建引导类
        Bootstrap bootstrap = new Bootstrap();
        //线程组
        NioEventLoopGroup boss = new NioEventLoopGroup();
        bootstrap.group(boss)   //指定线程组
                .channel(NioSocketChannel.class)    //指定线程模型
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //指定连接数据读写逻辑
                        ch.pipeline().addLast(new FirstClientHandler());
                    }
                });
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8000);
        if (channelFuture.isSuccess()){
            System.out.println("连接成功，准备发送测试数据。。。");
            /*Channel channel = channelFuture.channel();
            while (true){
                channel.writeAndFlush(new Date()+":Netty Test");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }
}
