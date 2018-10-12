package com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * @Description
 * @ClassName NettyServer
 * @Author Liumh
 * @Date 2018/10/10 19:34
 * @Version v1.0
 */
public class NettyServer {

    private static int port = 8000;

    /**
     * 创建一个netty服务端需要具备：
     *  线程模型（NioEventLoopGroup）
     *  IO模型（.channel(NioServerSocketChannel.class)）
     *  连接数据读写处理逻辑（.childHandle(...)）
     * @param args
     */
    public static void main(String[] args){
        //服务端引导类
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap.group(boss, worker) //为引导类配置两大线程组
                .channel(NioServerSocketChannel.class)  //指定服务端的IO模型
                //指定服务启动过程中的一些逻辑
                .handler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel ch) throws Exception {
                        System.out.println("服务端启动中。。。");
                    }
                })
                //为服务端channel指定自定义属性（类似于向map中put数据）
                .attr(AttributeKey.newInstance("serverName"), "nettyServer")
                //为每一个连接指定自定义属性
                .childAttr(AttributeKey.newInstance("clientName"), "nettyClient")
                //为每条连接设置一些TCP底层相关的属性
                .childOption(ChannelOption.SO_KEEPALIVE, true)  //开启TCP底层心跳机制
                .childOption(ChannelOption.TCP_NODELAY, true)   //开启Nagle算法
                //除了可以为每个连接设置以上属性以外，还可以给服务端channel设置一系列属性
                .option(ChannelOption.SO_BACKLOG, 1024) //用于存放临时已完成三次握手的请求的队列的最大长度
                //为引导类创建一个ChannelInitializer，定义后续每条连接的数据读写操作，业务处理逻辑
                //泛型参数NioSocketChannel是netty对Nio类型的连接的抽象
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(new StringDecoder());
                        nioSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
                                System.out.println(s);
                            }
                        });
                    }
                });
        bind(serverBootstrap, port);
    }

    public static void bind(ServerBootstrap serverBootstrap, int port){
        serverBootstrap.bind(port)
                //添加监听
                .addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()){
                    System.out.println("端口"+port+"绑定成功");
                }else {
                    System.out.println("端口"+port+"绑定失败");
                    bind(serverBootstrap, port+1);
                }
            }
        });
    }
}
