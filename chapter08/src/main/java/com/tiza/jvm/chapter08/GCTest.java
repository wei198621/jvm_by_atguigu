package com.tiza.jvm.chapter08;

import java.util.ArrayList;

/**
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 *
 * @author leowei
 * @date 2021/1/9  - 21:20
 */
public class GCTest {
    public static void main(String[] args) {
        int i=0;

        try {
            ArrayList<String> list = new ArrayList<String>();
            String a="leavint tiza .com ";
            while (true){
                list.add(a);
                a=a+a;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" 遍历次数： "+ i );
        }
    }
}
