package com.tiza.jvm.chapter23;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author leowei
 * @date 2021/1/28  - 22:19
 *
 * 链接阶段 准备环节赋值在哪里进行？
 * 结论：
 * 使用  static + final 修饰， and
 *                显式赋值不涉及到方法或构造器的调用 （字面量方式赋值） and
 *                           基本数据类型或者String 类型 的显式赋值，在链接阶段的准备环节进行。
 */
public class InitializationTest2 {

    public static int a=1;                             // 在初始化阶段 <clinit>()中赋值
    public static final int INT_CONSTANT =10;          // 在链接阶段准备环节赋值

    public static final Integer INTEGER_CONSTANT1 = Integer.valueOf(10);  // 在初始化阶段 <clinit>()中赋值
    public static Integer INTEGER_CONSTANT2 = Integer.valueOf(10);        // 在初始化阶段 <clinit>()中赋值

    public static final String s0= "helloworld0";                              // 在链接阶段准备环节赋值
    public static final String s1 = new String("helloworld2");    // 在初始化阶段 <clinit>()中赋值

}
