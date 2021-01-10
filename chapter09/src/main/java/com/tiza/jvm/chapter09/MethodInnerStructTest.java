package com.tiza.jvm.chapter09;

import java.io.Serializable;

/**
 * @author leowei
 * @date 2021/1/10  - 21:28
 */
public class MethodInnerStructTest extends Object implements Comparable<String>,Serializable {

    //属性
    public int num=10;
    private static String str="测试方法的内部结构";
    //构造器
    //方法
    public void test1(){
        int count=20;
        System.out.println("count="+count);
    }
    public static int test2(int cal){
        int result=0;
        try {
            int value=30;
            result = value/cal;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int compareTo(String o) {
        return 0;
    }
}
