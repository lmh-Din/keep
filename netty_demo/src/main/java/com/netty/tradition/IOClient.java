package com.netty.tradition;

import lombok.extern.slf4j.Slf4j;

import java.net.Socket;
import java.util.Date;

/**
 * @Description 传统IO客户端
 * @ClassName IOClient
 * @Author minghangliu
 * @Date 2018/9/26 下午10:36
 * @Version v1.0
 */
@Slf4j
public class IOClient {

    public static void main(String[] args) throws Exception{

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket("127.0.0.1", 8000);
                    while (true){
                        StringBuffer sendMsg = new StringBuffer();
                        Date date = new Date();
                        sendMsg.append(date.toString()).append(": Hello World");
                        socket.getOutputStream().write(sendMsg.toString().getBytes());
                        log.info("Client send:{}", sendMsg.toString());
                        Thread.sleep(2000);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
