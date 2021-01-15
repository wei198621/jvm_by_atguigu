package com.tiza.jvm.str_intern;

/**
 * @author leowei
 * @date 2021/1/15  - 7:57
 *
 * 如何保证变量S指向的字符串常量池中的数据呢？
 * 有两种方式：
 * 方式一：  String s ="wltest";  //字面量的方式
 * 方式二：  String s =new String("wltest").intern();
 *          String s =new StringBuilder("wltest").toString().intern();
 *
 *  String s = new String("1");
 *  1. 堆空间中的开辟一个区域存放“1”  ,字符串常量池中开辟一个区域放“1”  （6中放永久代  7,8 放堆中）
 *  s.intern();
 *  堆空间字符串常量池中找是否有“1” ，（当前是有）什么也不做
 *  String s2="1";
 *  s2 是 常量池中的地址
 */
public class StringIntern {
    public static void main(String[] args) {
      /*  String s = new String("1");
        s.intern();  //调用此方法之前 字符串常量池中已经有1了，所以什么也不做
        String s2 = "1";
        System.out.println(s == s2);  //JDK7/8 :  false  JDK6:  FALSE*/

        String s3 = new String("1") + new String("1");   // s3 变量的地址： new String("11")
        //执行完上一行代码后，字符串常量池是否存在 11  ，答  没有
        // 原因是  s3 地址是 StringBuilder 中的 toString 方法的new String() ，此new String () 比较特殊
        // ,只会执行在堆中分配 ， 不会执行在字符串常量池中分配
        s3.intern();         //在字符串常量池中生成  11
                             // jdk6：  创建一个新的对象“11”，有了新的地址
                             // jdk7：  此时常量池中没有创建11 ，而是创新了一个指向对空金new String("ss")的地址 。
        String s4 = "11";    //s4变量记录的地址：使用的是上一行代码执行时，在常量池中生成的"11"的地址
        System.out.println(s3 == s4);  //JDK7/8 :  TRUE  JDK6:  FALSE
    }
}
