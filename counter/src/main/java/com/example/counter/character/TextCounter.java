package com.example.counter.character;

import com.example.counter.util.FilterProcessManager;
import com.example.counter.util.ReadFiles;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Description
 * @ClassName TextCounter
 * @Author Liumh
 * @Date 2018/11/12 15:46
 * @Version v1.0
 */
@Slf4j
public class TextCounter {

    public static void main(String[] args){
        /*String text = "https://juejin.im/post/5bd64fade51d45657932b8dc asdasdasdfnin您萨达十大大声道";
        FilterProcessManager manager = new FilterProcessManager();
        manager.start();
        text = manager.process(text);
        log.info("{}",text.length());*/
        scanDir2Lines("C:\\Users\\Liumh\\Desktop\\testDir");
    }

    private static void scanDir2Lines(String filePath){
        ReadFiles.getAllFiles(filePath, ".md");
        List<String> lines = ReadFiles.getAllFileContent();
        log.info("lines-size:[{}]", lines.size());
        log.info("lines-content:[{}]", lines);
    }
}
