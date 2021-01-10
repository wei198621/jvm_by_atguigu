package com.tiza.jvm.chapter08;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author leowei
 * @date 2021/1/9  - 20:22
 */
public class HeapInstanceTest {

    byte[] buffer =new byte[new Random().nextInt(1024*200)];

    public static void main(String[] args) {
        ArrayList<HeapInstanceTest> list=new ArrayList<HeapInstanceTest>();
        while (true){
            list.add(new HeapInstanceTest());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
