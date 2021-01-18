package com.tiza.jvm.chapter21;

/**
 * @author leowei
 * @date 2021/1/18  - 23:55
 */
public class StringTest {
    public static void main(String[] args) {
        // 还是没有搞懂这块，待认真学习
        m1();
        m2();
        m3();
    }

    private static void m1() {
        String str1 =  new String("hello")+new String("world");
        String str2 ="helloworld";
        System.out.println(str1 == str2);  // false      str1  在堆中创建 helloworld     str2 在 stringtable 中 创建 helloworld
    }

    private static void m2() {
        String str1 =  new String("helloworld") ;
        String str2 ="helloworld";
        System.out.println(str1 == str2);  // false       str1  在堆中创建 helloworld     str2 在 stringtable 中 创建 helloworld
    }

    private static void m3() {
        String str1 =  new String("hello")+new String("world");
        String str2 = new String("helloworld");
        System.out.println(str1 == str2);  // false      str1  在堆中创建 helloworld     str2 在 stringtable 中 创建 helloworld
    }
}
