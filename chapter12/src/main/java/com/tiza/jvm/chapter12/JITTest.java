package com.tiza.jvm.chapter12;

import java.util.ArrayList;

/**
 * @author leowei
 * @date 2021/1/12  - 23:35
 */
public class JITTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            list.add(" 狗升科技  ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
