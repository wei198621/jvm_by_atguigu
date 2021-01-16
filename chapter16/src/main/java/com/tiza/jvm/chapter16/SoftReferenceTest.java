package com.tiza.jvm.chapter16;

import java.lang.ref.SoftReference;

/**
 * @author leowei
 * @date 2021/1/16  - 20:57
 */
public class SoftReferenceTest {

    public static class User{
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        //method01();
        //method02();
        method03();

    }

    // 最基本的写法，不涉及垃圾回收
    private static void method01() {
        //创建对象，建立软引用   一步到位的写法，一行等于三行
        SoftReference<User> userSoftRef = new SoftReference<User>(new User(1, "leo"));
        //从软引用中重新获得强引用对象
        System.out.println(userSoftRef.get());//User{id=1, name='leo'}
    }

    // 垃圾回收前  垃圾回收后 看效果  由于堆空间足够大，所以打印没有问题
    private static void method02() {
        //创建对象，建立软引用   一步到位的写法，一行等于三行
        SoftReference<User> userSoftRef = new SoftReference<User>(new User(1, "leo"));
        //从软引用中重新获得强引用对象
        System.out.println(userSoftRef.get());//User{id=1, name='leo'}
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftRef.get());//User{id=1, name='leo'}

    }

    // 如果设置参数   -Xms10m -Xmx10m  -XX:+PrintGCDetails     ,  新生代 ： 老年代 =  1:2   =  3.3  :  6.7  ；
    // 新生代 只有3.3M  再分成  8:1:1 ，不够放7M 空间的
    private static void method03() {
        //创建对象，建立软引用   一步到位的写法，一行等于三行
        SoftReference<User> userSoftRef = new SoftReference<User>(new User(1, "leo"));
        //从软引用中重新获得强引用对象
        System.out.println(userSoftRef.get());  //User{id=1, name='leo'}
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftRef.get());  //User{id=1, name='leo'}   //此时堆空间内存充足
        try {
            // 配合 “参数  -Xms10m -Xmx10m” 的设置，让系统认为资源紧张，执行垃圾回收
            Byte[] b = new Byte[7 * 1024 * 1024  ];  //7M
        } catch (Exception e) {
            // java.lang.OutOfMemoryError: Java heap space
            e.printStackTrace();   //此处会报错，报错之前会执行gc ,gc 会回收 软引用  userSoftRef
        }finally {
            // 在报OOM之前，垃圾回收器会回收软引用的可达对象。
            System.out.println(userSoftRef.get());   //所以 Null
        }
    }
}
