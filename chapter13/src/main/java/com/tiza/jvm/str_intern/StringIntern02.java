package com.tiza.jvm.str_intern;

/**
 * Author: tz_wl
 * Date: 2021/1/15 13:46
 * Content:
 */
public class StringIntern02 {
    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1() {
        String s3 = new String("1") + new String("1");
        //创建有stringbuilder 堆空间 “1” 字符串常量池“1”  堆空间 “1” 字符串常量池“1”  堆空间“11”
        s3.intern();
        //判断“11” 在字符串常量池中是否存在“11” ，当前不存在，所以要在 字符串常量池中开启一个空间放“11”
        //jdk6 中 在常量池中  开辟一个区域放“11”
        //jdk7 8  常量池中   开辟一个区域 （由于堆中有了“11”） 放一个指向堆空间 “11” 的地址 (想想如果变量未1000个字符，此处指用4位引用地址就可以了，为了节省空间)
        String s4 = "11";
        System.out.println(s3==s4);  //jkd 6 false    jdk  7 8  true
    }

    private static void method2() {
        String s3 = new String("1") + new String("1");
        //创建有stringbuilder 堆空间 “1” 字符串常量池“1”  堆空间 “1” 字符串常量池“1”  堆空间“11” ,常量池中不存在“11”  s3实际指向的是堆空间new StringBuilder(**)的地址
        String s4 = "11";         // 在字符串常量池中  开辟一个空间放 11  其地址放在s4 里面
        s3.intern();              //判断“11” 在字符串常量池中是否存在“11” ，当前存在，所以什么也不做
        //jdk 6     :
        //jdk 7 8   :
        String s5 = s3.intern();  // s5 指向 字符串常量池中的“11”   也就是s4指向的地址

        System.out.println(s3==s4);  //jkd 6 false    jdk  7 8  false
        System.out.println(s4==s5);  //jkd 6 true    jdk  7 8  true
    }


}
