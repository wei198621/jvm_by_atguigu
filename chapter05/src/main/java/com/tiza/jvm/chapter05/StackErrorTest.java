package com.tiza.jvm.chapter05;

/**
 * @author leowei
 * @date 2021/1/6  - 22:20
 *
 * 自循环调用会报   java.lang.StackOverflowError 的异常
 * 默认栈大小情况下            调用次数    11406
 * 设置虚拟机栈大小  256k      调用次数    2467     (-Xss256k)
 *
 *
 */
public class StackErrorTest {
    private static int count=1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
