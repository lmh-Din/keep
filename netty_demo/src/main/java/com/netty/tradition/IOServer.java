package com.netty.tradition;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description 传统IO服务端
 * @ClassName IOServer
 * @Author minghangliu
 * @Date 2018/9/26 下午10:13
 * @Version v1.0
 */
@Slf4j
public class IOServer {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    //阻塞获取连接
                    try {
                        Socket socket = serverSocket.accept();
                        //创建一个新的线程用来读取数据
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    int len = 1024;
                                    byte[] bytes = new byte[len];
                                    InputStream inputStream = socket.getInputStream();
                                    //读取连接内容
                                    while ((len = inputStream.read(bytes)) != -1){
                                        log.info("Server read:{}", new String(bytes, 0, len));
                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
}
