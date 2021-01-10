package com.tiza.jvm.chapter08;

import javax.swing.text.SimpleAttributeSet;

/**
 * @author leowei
 * @date 2021/1/10  - 13:23
 * -XX:+EliminateAllocations:    开启标量替换，默认是开启的，允许将对象打散分配在栈上。
 * -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 * ------------------------------[GC (Allocation Failure)  25600K->1032K(98304K), 0.0007479 secs]
 * ------------------------------花费时间为19 ms
 * -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * ----------------------------- 花费时间为8 ms
 */
public class ScalarReplace {
    public static class User{
        public int id;
        public String name;
    }
    public static void alloc(){
        User u =new User();  // 未发生逃逸
        u.id =5;
        u.name ="www.atguigu.com";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间为" + (end - start) + " ms");
    }
}
