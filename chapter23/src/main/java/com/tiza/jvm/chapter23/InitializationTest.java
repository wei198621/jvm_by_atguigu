package com.tiza.jvm.chapter23;

/**
 * @author leowei
 * @date 2021/1/28  - 21:30
 */
public class InitializationTest {
    // 静态字段显示赋值方式1
    public static int id=1;
    public static int number;
    // 静态字段显示赋值方式2
    static{
        number =2 ;
        System.out.println("father static{} ");
    }
}
