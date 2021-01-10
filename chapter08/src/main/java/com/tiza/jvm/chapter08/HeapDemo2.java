package com.tiza.jvm.chapter08;

/**
 *
 * -Xms10m -Xmx10m
 *
 * @author leowei
 * @date 2021/1/9  - 10:32
 */
public class HeapDemo2 {
    public static void main(String[] args) {
        System.out.println(" start ...");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" end ...");
    }
}
