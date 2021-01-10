package com.tiza.jvm.chapter08;

/**
 * @author leowei
 * @date 2021/1/10  - 12:34
 *                   -DoEscapeAnalysis   不开启逃逸分析
 *                   +DoEscapeAnalysis   开启逃逸分析
 * -Xmx1g -Xms1g -XX:-DoEscapeAnalysis -XX:+PrintGCDetails          -----花费时间为：83ms
 * -Xmx1g -Xms1g -XX:+DoEscapeAnalysis -XX:+PrintGCDetails          -----花费时间为：4ms
 * -Xmx256m -Xms256m -XX:-DoEscapeAnalysis -XX:+PrintGCDetails      -----花费时间为：67ms  (执行了垃圾回收)
 * -Xmx256m -Xms256m -XX:+DoEscapeAnalysis -XX:+PrintGCDetails      -----花费时间为：4ms
 *
 */
public class StackAllocation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {   //1000 万次
            alloc();
        }
        long end =System.currentTimeMillis();
        System.out.println("花费时间为："+ (end-start)+ "ms");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void alloc(){
        User user = new User();       // 此对象未发生逃逸  ，所以在栈中分配 ，不用垃圾回收
    }

    static class User{

    }
}
