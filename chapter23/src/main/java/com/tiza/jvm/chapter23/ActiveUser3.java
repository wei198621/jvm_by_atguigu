package com.tiza.jvm.chapter23;

import org.junit.Test;

import java.io.Serializable;
import java.util.Random;

/**
 * @author leowei
 * @date 2021/1/29  - 22:28
 */
public class ActiveUser3 {


    /*
    4. 当使用java.lang.reflect包中的方法反射类的方法时。 比如Class.forName("com.tiza.java.Test")
    Order 类的初始化过程
     */
    @Test
    public void test1(){
        try {
            Class  clazz = Class.forName("com.tiza.jvm.chapter23.Order3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
    5. 当初始化子类时，如果发现其父类没有初始化，需要先触发其父类的初始化

    Father 类的初始化
    Son 类的初始化
    1
     */
    @Test
    public void test2(){
        System.out.println(Son.num);
    }

    /*
    5.1  初始化一个类时，并不会先初始化它所实现的接口
    Father 类的初始化
    Son 类的初始化
    1
     */
    @Test
    public void test3(){
        System.out.println(Son2.num);
    }

    /*
    5.2  初始化一个接口时，并不会先初始化他的父接口
    CompareC 的初始化
    0
     */
    @Test
    public void test4(){
        System.out.println(CompareC.NUM1);
    }

}

class Order3 implements Serializable {
    static {
        System.out.println("Order 类的初始化过程");
    }

    public static void method1(){
        System.out.println("order method() .... ");
    }
}


class Father{
    static {
        System.out.println("Father 类的初始化");
    }
}

class Son extends Father{
    static {
        System.out.println("Son 类的初始化");
    }
    public static int num=1;
}

class Son2 extends Father implements CompareB{
    static {
        System.out.println("Son 类的初始化");
    }
    public static int num=1;
}

interface CompareB{
    public static final Thread t =new Thread(){
        {
            System.out.println("CompareB 的初始化");
        }
    };
}

interface CompareC extends CompareB{
    public static final Thread t =new Thread(){
        {
            System.out.println("CompareC 的初始化");
        }
    };

    public static int NUM1 =new Random().nextInt(10);
}

