package com.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
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
                            //遍历所有连接
                            while (iteratorKey.hasNext()){
                                SelectionKey key = iteratorKey.next();
                                //判断当前key的通道是否可以接收一个新的连接
                                if (key.isAcceptable()){
                                    try {
                                        SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                        clientChannel.configureBlocking(false);
                                        clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }finally {
                                        iteratorKey.remove();
                                    }
                                }
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        if (clientSelector.select(1) > 0){
                            Set<SelectionKey> set = clientSelector.selectedKeys();
                            Iterator<SelectionKey> clientKeys = set.iterator();
                            while (clientKeys.hasNext()){
                                SelectionKey selectionKey = clientKeys.next();
                                if (selectionKey.isReadable()){
                                    try {
                                        SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                                        clientChannel.read(buffer);
                                        buffer.flip();
                                        System.out.println(Charset.defaultCharset().decode(buffer).toString());
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }finally {
                                        clientKeys.remove();
                                        selectionKey.interestOps(SelectionKey.OP_READ);
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
