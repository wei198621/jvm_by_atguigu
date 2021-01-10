package com.tiza.jvm.chapter08;

import java.util.ArrayList;
import java.util.Random;

/**
 * -Xms600m -Xmx600m
 * @author leowei
 * @date 2021/1/9  - 15:58
 */
public class OOMtest {
    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<Picture>();
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list.add(new Picture(new Random().nextInt(1024*1024)));
        }


    }

}



class Picture{
    private byte[] pixels;
    public Picture(int length){
        this.pixels =new byte[length];
    }
}
