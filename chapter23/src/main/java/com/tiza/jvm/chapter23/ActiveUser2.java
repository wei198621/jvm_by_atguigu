package com.tiza.jvm.chapter23;

import org.junit.Test;
import java.util.Random;

/**
 * @author leowei
 * @date 2021/1/28  - 23:55
 *
 * https://www.bilibili.com/video/BV1PJ411n7xZ?p=277
 *
3.  当使用类、接口的静态字段时(final修饰特殊考虑)
 *
 */
public class ActiveUser2 {

    /**
     User 类的初始化过程
     1
     */
    @Test
    public void test1(){
        System.out.println(User.num);
    }

    /**
     2
     */
    @Test
    public void test2(){
        System.out.println(User.num2);
    }

    /**
     User 类的初始化过程
     8
     */
    @Test
    public void test3(){
        System.out.println(User.num3);
    }

    /**
     1
     没有初始化
     */
    @Test
    public void test4(){
        System.out.println(CompareA.NUM);
    }

    /**
     CompareA的初始化
     6
     */
    @Test
    public void test5(){
        System.out.println(CompareA.NUM2);
    }

}

class User{
    static {
        System.out.println(" User 类的初始化过程");
    }
    public static int num =1;
    public static final int num2=2;
    public static final int num3 = new Random().nextInt(10);

}


interface CompareA{
    public static final Thread t=new Thread(){
        {
            System.out.println("CompareA的初始化");
        }
    };
    public static final int NUM =1 ;
    public static final int NUM2 = new Random().nextInt(10);
}