package com.tiza.jvm.chapter23;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Random;

/**
 * @author leowei
 * @date 2021/1/29  - 23:31
 */
public class PassiveUse2 {

    /*
    1
     */
    @Test
    public void test1(){
        System.out.println(Person.NUM);
    }

    /*
     Person 的初始化
3

     */
    @Test
    public void test2(){
        System.out.println(Person.NUM2);
    }

    /*
     1
     */
    @Test
    public void test3(){
        System.out.println(SerialA.NUM1);
    }

    /*
    SerialA 的初始化
    9
     */
    @Test
    public void test4(){
        System.out.println(SerialA.NUM2);
    }
/*
4. 调用ClassLoader类的LoadClass()方法加载一个类，并不是对类的主动使用，不会导致类的初始化
     Class.forName(**) 阈值相反，是主动调用
 */

    @Test
    public void test5(){
        try {
            ClassLoader.getSystemClassLoader().loadClass("com.tiza.jvm.chapter23.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

class Person{
    static {
        System.out.println(" Person 的初始化 ");
    }
    public static final int NUM =1 ;      //  在链接过程的准备环节就被赋值为1 了 ，
    public static final int NUM2 = new Random().nextInt(10);
}



interface SerialA{
    public static final Thread t =new Thread(){
        {
            System.out.println("SerialA 的初始化");
        }
    };

    public static int NUM1 =1;
    public static int NUM2= new Random().nextInt(10);  // 此赋值操作需要在<clinit>方法中执行
}

