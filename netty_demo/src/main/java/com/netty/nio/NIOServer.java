package com.netty.nio;

import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description
 * @ClassName NIOServer
 * @Author minghangliu
 * @Date 2018/9/30 下午1:43
 * @Version v1.0
 */
public class NIOServer {

    public static void main(String[] args) throws Exception{
        //创建选择器
        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //对应IO编程中服务端启动
                    ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                    //绑定端口
                    listenerChannel.socket().bind(new InetSocketAddress(8000));
                    //配置通道阻塞模式
                    listenerChannel.configureBlocking(false);
                    listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                    while (true){
                        //检测是否有新连接进入，阻塞时间为1ms
                        if (serverSelector.select(1) > 0){
                            Set<SelectionKey> set = serverSelector.selectedKeys();
                            Iterator<SelectionKey> iteratorKey = set.iterator();
                            while (iteratorKey.hasNext()){
                                SelectionKey key = iteratorKey.next();
                                if (key.isAcceptable()){
                                    try {
                                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
