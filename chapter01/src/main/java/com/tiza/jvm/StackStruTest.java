package com.tiza.jvm;

/**
 * @author leowei
 * @date 2021/1/3  - 15:57
 */
public class StackStruTest {
    public static void main(String[] args) {
        int i=2;
        int j=3;
        int k=i+j;

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello Stack");
    }
}
