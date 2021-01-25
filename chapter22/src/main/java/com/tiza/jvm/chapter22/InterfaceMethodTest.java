package com.tiza.jvm.chapter22;

/**
 * @author leowei
 * @date 2021/1/25  - 22:03
 */
public class InterfaceMethodTest {


    /**
     *

     0 new #2 <com/tiza/jvm/chapter22/Son>
     3 dup
     4 invokespecial #3 <com/tiza/jvm/chapter22/Son.<init>>
     7 astore_1
     8 aload_1
     9 invokeinterface #4 <com/tiza/jvm/chapter22/Father.method2> count 1
     14 invokestatic #5 <com/tiza/jvm/chapter22/Father.method1>
     17 return

     * @param args
     */
    public static void main(String[] args) {
        Father f = new Son();
        f.method2();
        Father.method1();
    }
}

interface Father{
    public static void method1(){

    }
    public default void method2(){

    }
}

class Son implements Father{

}