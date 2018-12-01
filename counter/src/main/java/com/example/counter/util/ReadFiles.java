package com.example.counter.util;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @ClassName ReadFiles
 * @Author Liumh
 * @Date 2018/11/12 16:00
 * @Version v1.0
 */
public class ReadFiles {

    private static List<String> listFilePath = new ArrayList<>();

    private static List<String> listFileContent = new ArrayList<>();

    /**
     * 获取指定文件夹下所有 @fileType 类型的文件地址
     * @param path
     * @param fileType
     * @return
     */
    public static void getAllFiles(String path, String fileType){
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f:files) {
            if (f.isDirectory()){
                getAllFiles(f.getPath(), fileType);
            }else {
                String filePath = f.getPath();
                if (filePath.endsWith(fileType)){
                    listFilePath.add(filePath);
                }
            }
        }
    }

    public static List<String> getAllFileContent(){
        System.out.println(listFilePath.toString());
        try {
            for (String filePath:listFilePath) {
                Stream<String> streamString = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8);
                List<String> lines = streamString.collect(Collectors.toList());
                listFileContent.addAll(lines);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listFileContent;
    }
}
