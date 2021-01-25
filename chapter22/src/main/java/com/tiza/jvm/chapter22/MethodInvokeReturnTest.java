package com.tiza.jvm.chapter22;

import java.util.Date;

/**
 * @author leowei
 * @date 2021/1/25  - 21:43
 */
public class MethodInvokeReturnTest {

    public static void main(String[] args) {

    }

    //方法调用  invokespecial: 静态分配

    /**
     0 new #2 <java/util/Date>
     3 dup
     4 invokespecial #3 <java/util/Date.<init>>
     7 astore_1
     8 new #4 <java/lang/Thread>
     11 dup
     12 invokespecial #5 <java/lang/Thread.<init>>
     15 astore_2
     16 aload_0
     17 invokespecial #6 <java/lang/Object.toString>
     20 pop
     21 aload_0
     22 invokespecial #7 <com/tiza/jvm/chapter22/MethodInvokeReturnTest.methodPrivate>
     25 return

     */
    public void invoke1(){
        Date date = new Date();       // 情况1： 类实例构造方法
        Thread t1 = new Thread();
        super.toString();              // 情况2： 父类方法
        methodPrivate();               // 情况3： 私有方法
    }
    private void methodPrivate(){

    }
    public void methodPublic(){

    }

    /**
     0 invokestatic #8 <com/tiza/jvm/chapter22/MethodInvokeReturnTest.methodStatic>
     3 invokestatic #9 <com/tiza/jvm/chapter22/MethodInvokeReturnTest.methodStaticPrivate>
     6 return

     方法调用  invokestatic
     */
    public void invoke2(){
        methodStatic();
        methodStaticPrivate();
    }
    public static void methodStatic(){

    }
    private static void methodStaticPrivate(){

    }


    /**   方法调用指令  ： invokeinterface
     0 new #4 <java/lang/Thread>
     3 dup
     4 invokespecial #5 <java/lang/Thread.<init>>
     7 astore_1
     8 aload_1
     9 invokeinterface #10 <java/lang/Runnable.run> count 1
     14 aconst_null
     15 astore_2
     16 aload_2
     17 bipush 123
     19 invokestatic #11 <java/lang/Integer.valueOf>
     22 invokeinterface #12 <java/lang/Comparable.compareTo> count 2
     27 pop
     28 return
     */
    public void invoke3(){
        Thread t1 = new Thread();  // invokespecial
        ((Runnable)t1).run();      // invokeinterface

        Comparable<Integer> com =null;  // Integer.valueOf  invokestatic
        com.compareTo(123);             // invokeinterface
    }

    /**   方法调用指令 ：   invokeVirtual   动态分派
     0 getstatic #13 <java/lang/System.out>
     3 ldc #14 <hello>
     5 invokevirtual #15 <java/io/PrintStream.println>
     8 new #4 <java/lang/Thread>
     11 dup
     12 invokespecial #5 <java/lang/Thread.<init>>
     15 astore_1
     16 aload_1
     17 invokevirtual #16 <java/lang/Thread.run>
     20 return

     */
    public void invoke4(){
        System.out.println("hello");   // invokevirtual
        Thread t1 = new Thread();      // invokespecial
        t1.run();                      // invokevirtual
    }


    //  ********************   返回值 测试   ************************

    /**
     0 bipush 40
     2 istore_1
     3 iload_1
     4 ireturn

     * @return
     */
    public int returnInt(){
        int i =40;
        return i;
    }

    /**
     *
     0 dconst_0
     1 dreturn

     * @return
     */
    public double returnDouble(){
        return 0.0;
    }


    /**
     *
     0 ldc #17 <hello,world>
     2 areturn

     * @return
     */
    public String returnString(){
        return "hello,world";
    }

    /**
     0 aconst_null
     1 areturn

     * @return
     */
    public int[] returnArr(){
        return null;
    }

    /**
     0 bipush 10
     2 istore_1
     3 iload_1
     4 i2f
     5 freturn

     */
    public float returnFloat(){
        int i=10;
        return i;
    }

    /**
     0 iconst_0
     1 ireturn

     * @return
     */
    public byte returnByte(){
        return  0;
    }


}
