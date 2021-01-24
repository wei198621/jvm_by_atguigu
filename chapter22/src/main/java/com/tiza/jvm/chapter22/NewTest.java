package com.tiza.jvm.chapter22;

import java.io.File;

/**
 * @author leowei
 * @date 2021/1/24  - 21:07
 */
public class NewTest {
    public static void main(String[] args) {
        System.out.println(NewTest.class.getClass());
    }
    public void newInstance(){
        Object o = new Object();
        File file = new File("tiza is die");
    }
    public void newArray(){
        int[] intArray = new int[10];
        Object[] objArray = new Object[10];
        int[][] mintArray = new int[10][10];
        String[][] strArray = new String[10][];
    }

    /**
     * 对应字节码
     *
     0 getstatic #2 <java/lang/System.out>------------------
     3 ldc #12 <hello>--------------------------------------
     5 invokevirtual #13 <java/io/PrintStream.print>--------
     8 return-----------------------------------------------

     */
    public void sayHello(){
        System.out.print("hello");
    }
}
