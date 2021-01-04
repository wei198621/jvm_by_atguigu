package com.tiza.jvm.chapter02;


/**
 * @author leowei
 * @date 2021/1/4  - 22:49
 */
public class ClassInitTest {

    // 任何一个类声明以后， 内部至少存在一个类构造器
    public ClassInitTest(){
        num =10;
        int d=2;
    }

    private static int num =1 ;  // 会在 <clinit> 中执行

    static {
        num =2;
        num2 =20;
        System.out.println("num = " + num);
        // System.out.println("num2 = " + num2);   // 报错 非法的前向 引用
    }

    public static int num2 = 10;


    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);         // 2
        System.out.println(ClassInitTest.num2);        //10
    }
}
