package com.tiza.jvm.chapter15;

/**
 *
 * -XX:+PrintGCDetails
 * @author leowei
 * @date 2021/1/16  - 7:13
 */
public class RefCountGC {
    private byte[] bigSize =new byte[5*1024*1024]; // 5M
    Object reference=null;

    public static void main(String[] args) {
        //MethodWithoutGC();
        MethodWithGC();
    }

    private static void MethodWithoutGC() {
        RefCountGC obj1 = new RefCountGC();
        RefCountGC obj2 = new RefCountGC();
        obj1.reference =obj2;
        obj2.reference =obj1;

        obj1 = null;
        obj2=null;
    }

    private static void MethodWithGC() {
        RefCountGC obj1 = new RefCountGC();
        RefCountGC obj2 = new RefCountGC();
        obj1.reference =obj2;
        obj2.reference =obj1;

        obj1 = null;
        obj2=null;
        System.gc();
        // obj1  obj2 存在循环引用问题，如果使用的是标记清除算法，无法及时回收，
        // 但是单效果是由回收的，所以反证java平台没有使用垃圾回收算法

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
