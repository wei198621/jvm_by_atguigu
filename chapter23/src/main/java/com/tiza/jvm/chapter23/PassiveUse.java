package com.tiza.jvm.chapter23;

import org.junit.Test;

/**
 * @author leowei
 * @date 2021/1/29  - 23:25
 *
 *

1. 当访问一个静态字段时，只有真正声明该字段的类才会被初始化，
当通过子类引用父类的静态变量，不会导致子类的初始化
2. 通过数组定义类的引用，不会触发此类的初始化


 *
 *
 */
public class PassiveUse {

    /*
    1. 当访问一个静态字段时，只有真正声明该字段的类才会被初始化，
当通过子类引用父类的静态变量，不会导致子类的初始化

     father is init....
      1
     */
    @Test
    public void test1(){
        System.out.println(ChildA.NUM1);
    }

    //2. 通过数组定义类的引用，不会触发此类的初始化
    //什么都没有打印
    @Test
    public void test2(){
        FatherA[] fathers = new FatherA[10];
    }

}

class FatherA {
    static{
        System.out.println(" father is init....");
    }

    public static int NUM1 = 1;
}

class ChildA extends FatherA{
    static {
        System.out.println(" child is init ...");
    }
}