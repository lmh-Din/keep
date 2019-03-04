package com.example.basic.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**
 * @Description Java网络操作
 * @ClassName NetOperate
 * @Author Liumh
 * @Date 2019/2/12 13:40
 * @Version v1.0
 */
public class NetOperate {

    public static void main(String[] args){
        InetTest();
        URLTest();
    }

    private static void InetTest(){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void URLTest(){
        String url = "https://www.baidu.com";
        try {
            URL baidu = new URL(url);
            InputStream inputStream = baidu.openStream();
            InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void socketTest(){

    }
}
