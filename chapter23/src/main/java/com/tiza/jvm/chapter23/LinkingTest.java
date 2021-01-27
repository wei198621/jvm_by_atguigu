package com.tiza.jvm.chapter23;

/**
 * @author leowei
 * @date 2021/1/27  - 23:40
 * static final 静态常量值 ，在类加载阶段(Loading,linking,Initializaing,Using,Unloading)的
 * Linking阶段 （验证、准备、解析）的准备阶段就给此类赋值了。
 *
 * 基本数据类型：  非final 变量，准备环节进行默认初始化赋值
 *                 final 变量， 准备环节进行显示赋值
 */
public class LinkingTest {
    private static long id;
    private static final int num=1;
    private static final String conStr ="CONST";
    //同样是给 static final String 赋值，静态字面量有 constantValue ，New 的没有
    private static final String conStr02 = new String("Const02");

}
