package com.tiza.jvm.str_intern;

/**
 * @author leowei
 * @date 2021/1/15  - 8:20
 */
public class StringIntern01 {
    public static void main(String[] args) {


        //这个语句做了什么
        //String str = new String("ab");
          /*
          0 new #2 <java/lang/String>
          3 dup
          4 ldc #3 <ab>
          6 invokespecial #4 <java/lang/String.<init>>
          9 astore_1
          10 return
          */

        String str2 = new String("ab").intern();
        /*
        0 new #2 <java/lang/String>
        3 dup
        4 ldc #3 <ab>
        6 invokespecial #4 <java/lang/String.<init>>
        9 invokevirtual #5 <java/lang/String.intern>
        12 astore_1
        13 return
        */

        //jdk6
        //  1. 堆空间创建一个对象  ab
        //  2. 堆空间字符串常量池中创建一个对象  ab

        //jdk7 / 8
        //  1. 堆空间创建一个对象  ab
        //  2. 堆空间字符串常量池中创建一个对象(其存放地址) 地址其指向堆空间中的ab



    }
}
