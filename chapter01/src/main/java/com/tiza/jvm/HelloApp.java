package com.tiza.jvm;

/**
 * @author leowei
 * @date 2021/1/4  - 22:40
 */
public class HelloApp {

    private static int a=1;   //prepare : a=0  --> initial  a=1;
    public final static int b=2; //  final 在编译的时候就会分配了，准备阶段会显示初始化

    public static void main(String[] args) {
        System.out.println(a);
    }
}
