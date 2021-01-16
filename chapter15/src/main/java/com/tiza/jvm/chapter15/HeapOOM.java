package com.tiza.jvm.chapter15;

import java.util.ArrayList;

/**
 * @author leowei
 * @date 2021/1/16  - 11:16
 * -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 *
 * https://www.bilibili.com/video/BV1PJ411n7xZ?p=146
 *
 */
public class HeapOOM {

    byte[] buffer = new byte[1*1024*1024];  // 1MB

    public static void main(String[] args) {
        ArrayList<HeapOOM> list = new ArrayList<HeapOOM>();
        int count=0;
        try {
            while (true){
                list.add(new HeapOOM());
                count++;
            }
        } catch (Exception e) {
            System.out.println("count="+ count);
            e.printStackTrace();
        }

    }
}
