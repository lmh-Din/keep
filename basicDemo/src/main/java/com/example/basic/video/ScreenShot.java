package com.example.basic.video;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description 视频截图
 * @ClassName ScreenShot
 * @Author Liumh
 * @Date 2018/10/19 17:06
 * @Version v1.0
 */
public class ScreenShot {


    public static void main(String[] args) throws Exception{
        String videoURL = "http://flv2.bn.netease.com/videolib3/1606/23/RiTxE9164/SD/RiTxE9164-mobile.mp4";
        URL url = new URL(videoURL);
        URLConnection connection = url.openConnection();
        InputStream ins = connection.getInputStream();
    }

    private void getVideoShotImg(String filePath, String imgPath){

        List<String> commands = new ArrayList<>();
        commands.add(imgPath);

        commands.add("-i");

        commands.add(filePath);

        commands.add("-y");

        commands.add("-f");

        commands.add("image2");

        commands.add("-ss");

        commands.add("1");//这个参数是设置截取视频多少秒时的画面

        commands.add("-t");

        commands.add("0.001");

        commands.add("-s");

        commands.add("1920x1080");//宽X高

        commands.add(new Date()+".jpg");

        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(commands);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
