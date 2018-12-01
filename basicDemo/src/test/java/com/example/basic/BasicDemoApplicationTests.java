package com.example.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class BasicDemoApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println(System.getProperty("user.dir"));

	}

	@Test
	public void subStringTest(){
		String filePath = "/temp/终端调拨明细导入模板.xlsx";
		int lastIndex = filePath.lastIndexOf("/");
		System.out.println(filePath.substring(lastIndex+1, filePath.length()));
	}

}
