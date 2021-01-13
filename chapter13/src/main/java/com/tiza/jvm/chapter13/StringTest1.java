package com.tiza.jvm.chapter13;

import org.junit.Test;

/**
 * @author leowei
 * @date 2021/1/13  - 21:33
 */
public class StringTest1 {
    @Test
    public void test(){
        // 通过字面量的方式定义，如下：s1,s2 都执行字符串常量池的"abc"(jdk7 8是在堆空间 ； jdk 6 在方法区)
        String s1="abc";
        String s2 ="abc";
        System.out.println(s1==s2);  //true

        // 通过 new ，放在不同区域
        String str1=new String("abc");
        String str2=new String("abc");
        System.out.println(str1==str2);  //false
    }


    @Test
    public void test01() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println("s1==s2");
        System.out.println(s1);   //acb
        System.out.println(s2);   //abc
        System.out.println("====================");
        s1 = "hello";
        System.out.println(s1);   //hello
        System.out.println(s2);   //abc
    }

    @Test
    public void test02() {
        String s1 = "abc";
        String s2 = "abc";
        s2+="def";
        System.out.println(s1);  //abc
        System.out.println(s2);  //abcdef
    }

    @Test
    public void test03() {
        String s1 = "abc";
        String s2 = s1.replace('a','m');
        System.out.println(s1); //abc
        System.out.println(s2); //mbc
    }

}
