package com.tiza.jvm.chapter16;

/**
 * @author leowei
 * @date 2021/1/16  - 13:39
 */
public class SystemGCTest {
    public static void main(String[] args) {
        new SystemGCTest();
        System.gc();  // 提醒JVM 执行垃圾收集行为，但是不能确定，是否马上执行
        //System.gc()  调用   Runtime.getRuntime().gc();

      // System.runFinalization();  //强制调用失去引用对象的finalize方法
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGCTest 重写了  finalizer ()  方法 ");
    }
}
