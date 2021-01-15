package com.tiza.jvm.str_intern;

/**
 * Author: tz_wl
 * Date: 2021/1/15 15:13
 * Content:
 */
public class stringInternEx02 {
    public static void main(String[] args) {
        mehtod1();
        mehtod2();
    }

    private static void mehtod1() {
        // s1 地址是堆空间"ab" 的地址，此时 字符串常量池中，没有"ab"
        String s1= new String("a")+ new String("b");
        s1.intern();
        // jdk 6   时候 ： 此时将在字符串常量池中开辟一个空间，放入"ab"
        // jdk 7/8 时候 ： 此时将在字符串常量池中开辟一个空间，放入 堆空间中 “ab” 的地址， 也就是栈中地址指向堆“ab” ,字符串常量池中地址指向堆中“ab"
        String s2="ab";   //s2 是字符串常量池中"ab" 的地址
        System.out.println(s1==s2);   //jdk6 false  ;  jdk7/8 true
    }


    private static void mehtod2() {
        // s1 地址是堆空间"ab" 的地址，此时 字符串常量池中有"ab"
        String s1 = new String("ab");
        s1.intern();  // 此时字符串常量池中有了“ab” 所以什么也不做
        String s2="ab";   //s2 是字符串常量池中"ab" 的地址
        System.out.println(s1==s2);   //jdk6 false ;  jdk7/8 false
    }
}
