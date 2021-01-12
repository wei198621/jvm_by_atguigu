package com.tiza.jvm.chapter11;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * @author leowei
 * @date 2021/1/12  - 21:44
 *  本机测试 180 次
 * java.lang.OutOfMemoryError: Direct buffer memory
 */
public class BufferTestOutOfMemory {
    private static final int BUFFER=1024*1024*20;  //20M
    public static void main(String[] args) {
        ArrayList<ByteBuffer> list = new ArrayList<ByteBuffer>();
        int count=0;
        while(true){
            //不断的将20M 的数据往 list 中加  看oom 时候的报错，及count
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
            list.add(byteBuffer);
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(count);
            }
        }
    }
}
