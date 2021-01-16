package com.tiza.jvm.chapter16;

/**
 * @author leowei
 * @date 2021/1/16  - 20:38
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
       // method01();
        //method02();
        method03();
    }

    private static void method01() {
        StringBuffer str = new StringBuffer("hello tiza!");
        System.gc();   // 由于gc不一定立即执行所以需要有个3秒的延时
        try {
            Thread.sleep(3000);      //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str);  // hello tiza!
    }
    private static void method02() {
        StringBuffer str = new StringBuffer("hello tiza!");
        str=null;
        System.gc();   // 由于gc不一定立即执行所以需要有个3秒的延时,本示例实测不sleep也没有问题，正常回收
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str);  //null
    }
    private static void method03() {
        StringBuffer str = new StringBuffer("hello tiza!");  // str  指向堆空间分配的StringBuffer地址
        StringBuffer str1=str;                               // str1 指向堆空间分配的StringBuffer地址
        str=null;
        System.gc();   // 由于gc不一定立即执行所以需要有个3秒的延时
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str);// null
        System.out.println(str1);// hello tiza!
    }
}
