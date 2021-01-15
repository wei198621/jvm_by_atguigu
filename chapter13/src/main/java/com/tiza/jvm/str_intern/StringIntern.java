package com.tiza.jvm.str_intern;

/**
 * @author leowei
 * @date 2021/1/15  - 7:57
 *
 *  String s = new String("1");
 *  1. 堆空间（常量池）中的 1   ，2.栈空间 的地址
 *  s.intern();
 *  调用此防范前常量池中已经存在了1 ，什么也不做
 *  String s2="1";
 *  s2 是 常量池中的地址
 */
public class StringIntern {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);  //JDK7/8 :  false  JDK6:  FALSE

      /*  String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);  //JDK7/8 :  TRUE  JDK6:  FALSE
        */
    }
}
