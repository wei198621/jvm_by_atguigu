package com.tiza.jvm.str_intern;

/**
 * Author: tz_wl
 * Date: 2021/1/15 14:39
 * Content:
 *
 * https://www.bilibili.com/video/BV1PJ411n7xZ?p=129
 *
 */
public class StringInternEx01 {
    //
    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1() {
        String s= new String("a")+ new String("b");   //s 存放的是 堆空间 中"ab" 的地址
        //上述代码           会在堆中new 一个对象放"ab"，但是不会在字符串常量中开辟空间放"ab"
        // new String("ab") 会在堆中new 一个对象放"ab"，   也会在字符串常量中开辟空间放"ab"
        String s2 = s.intern();
        //jdk6     查看 字符串常量池中是否有空间已经存放“ab” ，当前没有，会在字符串常量池中开启一个空间放"ab",并将其地址给s2
        //jdk7/8                                                 ,会在字符串常量池中开启一个空间,其存放堆中“ab”的地址
        System.out.println(s2=="ab");  // jkd6: true   jkd7/8: true
        System.out.println(s=="ab");   // jkd6: false  jkd7/8: true
    }

    private static void method2() {
        String x= "ab";                                                //在字符串常量池中开辟一个空间，放入"ab"
        String s= new String("a")+ new String("b");   //s 存放的是 堆空间 中"ab" 的地址
        //上述代码           会在堆中new 一个对象放"ab"，但是不会在字符串常量中开辟空间放"ab"

        String s2 = s.intern();         //s中指向的内容“ab” 在 字符串常量池中，已经存在，所以此步骤不做字符串常量池创建工作，只会把 字符串常量池“ab”的地址给s2
        //jdk6     查看 字符串常量池中是否有空间已经存放“ab” ，当前  有，也就是x的内容 ， s2 = x
        //jdk7/8                                                 ,会在字符串常量池中开启一个空间,其存放堆中“ab”的地址
        System.out.println(s2=="ab");  // jkd6: true   jkd7/8: true
        System.out.println(s=="ab");   // jkd6: false  jkd7/8: false
    }
}
