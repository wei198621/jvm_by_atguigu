package com.tiza.jvm.chapter09;

/**
 * @author leowei
 * @date 2021/1/10  - 21:59
 */
public class MethodAreaTest {
    public static void main(String[] args) {
        Order order =null;
        order.hello();
        System.out.println(Order.count);
    }
}

class Order{
    // 查看 Order.class 文件中下面两个域 编译后的效果
    public static int count=1;
    public static final int number=2;

    public static void hello(){
        System.out.println("hello");
    }
}
