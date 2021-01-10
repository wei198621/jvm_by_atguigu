package com.tiza.jvm.chapter05;

/**
 * @author leowei
 * @date 2021/1/8  - 22:44
 */
public class DynamicLinkingTest {

    int num =10;

    public void methodA(){
        System.out.println(" methodA()...");
    }

    public void methodB(){
        System.out.println("methodB() ... ");
        methodA();
        num++;
    }
}
