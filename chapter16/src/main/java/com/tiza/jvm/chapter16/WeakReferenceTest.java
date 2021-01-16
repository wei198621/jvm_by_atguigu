package com.tiza.jvm.chapter16;

import java.lang.ref.WeakReference;

/**
 * @author leowei
 * @date 2021/1/16  - 21:40
 */
public class WeakReferenceTest {

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
        method01();
    }
    // 弱引用特点 ，触发即回收
    private static void method01() {
        //创建对象，建立弱引用   一步到位的写法，一行等于三行
        WeakReference<User> userSoftRef = new WeakReference<User>(new User(1, "leo"));
        //从弱引用中重新获得强引用对象
        System.out.println(userSoftRef.get());//User{id=1, name='leo'}
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftRef.get());//null  不管内存空间是否充足，都会回收它

    }
}
