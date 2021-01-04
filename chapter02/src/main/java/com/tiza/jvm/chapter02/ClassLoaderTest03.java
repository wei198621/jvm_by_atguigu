package com.tiza.jvm.chapter02;

/**
 * @author leowei
 * @date 2021/1/5  - 0:36
 */
public class ClassLoaderTest03 {
    public static void main(String[] args) {

        // 1
        ClassLoader classLoader = null;
        try {
            classLoader = Class.forName("java.lang.String").getClassLoader();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("classLoader = " + classLoader);  // null

        // 2.
        ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
        System.out.println("classLoader1 = " + classLoader1);

        //3.
        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
        System.out.println("classLoader2 = " + classLoader2);

        // 4.
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println("classLoader3 = " + classLoader3);

     /*
           classLoader = null
           classLoader1 = sun.misc.Launcher$AppClassLoader@14dad5dc
           classLoader2 = sun.misc.Launcher$AppClassLoader@14dad5dc
           classLoader3 = sun.misc.Launcher$ExtClassLoader@28d93b30
           */


    }
}
