package com.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;

import java.nio.Buffer;
import java.nio.charset.Charset;

/**
 * @Description ByteBuf API测试
 * @ClassName ByteBufTest
 * @Author Liumh
 * @Date 2018/10/19 10:49
 * @Version v1.0
 */
@Slf4j
public class ByteBufTest {

    public static void main(String[] args){
        //为ByteBuf指定初始容量和最大容量
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(9, 100);
        printMsg("allocate ByteBuf(9, 100)", byteBuf);

        //write方法改变写指针，写完之后写指针未到capcity，buffer仍然可写
        byte[] bytes = new byte[]{'1','2','3','4'};
        byteBuf.writeBytes(bytes);
        printMsg("writeBytes(1,2,3,4)", byteBuf);

        //write方法改变写指针，写完之后写指针未到capcity，buffer仍然可写
        byteBuf.writeInt(12);
        printMsg("wirteInt(12)", byteBuf);

        //write方法改变写指针，写完之后指针到达capacity，buffer不可写
        byteBuf.writeBytes(new byte[]{'5'});
        printMsg("writeBytes(1)", byteBuf);

        // write 方法改变写指针，写的时候发现 buffer 不可写则开始扩容，扩容之后 capacity 随即改变
        byteBuf.writeBytes(new byte[]{6});
        printMsg("writeBytes(6)", byteBuf);

        //get方法不改变读写指针
        log.info("getByte:{}", byteBuf.getByte(3));
        log.info("getShort:{}", byteBuf.getShort(3));
        log.info("getInt:{}", byteBuf.getInt(3));
        printMsg("get", byteBuf);

        //set方法不改变读写指针
        byteBuf.setByte(byteBuf.readableBytes()+1, 0);
        printMsg("set", byteBuf);

        // read 方法改变读指针
        byte[] dst = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(dst);
        printMsg("readBytes(" + dst.length + ")", byteBuf);


    }

    private static void printMsg(String action, ByteBuf buf){
        log.info("after============={}===============", action);
        log.info("capacity:{}", buf.capacity());
        log.info("maxCapacity:{}", buf.maxCapacity());
        log.info("readerIndex:{}", buf.readerIndex());
        log.info("readableBytes:{}", buf.readableBytes());
        log.info("isReadable:{}", buf.isReadable());
        log.info("writerIndex:{}", buf.writerIndex());
        log.info("writableBytes:{}", buf.writableBytes());
        log.info("isWritable:{}", buf.isWritable());
        log.info("maxWritableBytes:{}", buf.maxWritableBytes());
        log.info("*******************************");
    }
}
