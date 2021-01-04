package com.tiza.jvm.chapter02;

/**
 * @author leowei
 * @date 2021/1/4  - 23:47
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);  //sun.misc.Launcher$AppClassLoader@14dad5dc


        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("extClassLoader = " + extClassLoader);   //sun.misc.Launcher$ExtClassLoader@28d93b30

        // 获取上层类加载器
        ClassLoader parent = extClassLoader.getParent();
        System.out.println("parent = " + parent);  // null  实际是bootStrapLoader ,此类由虚拟机定义

        //用户自定义类  的 classloader
        ClassLoader userDefineClsClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("userDefineClsClassLoader = " + userDefineClsClassLoader);   //sun.misc.Launcher$AppClassLoader@14dad5dc

        //String类 使用引导类加载器进行加载  --->  java 的核心类库 都是用 Bootstrap引导类加载器加载的
        ClassLoader strClassLoader1 = String.class.getClassLoader();
        System.out.println("strClassLoader1 = " + strClassLoader1);  //null


    }
}
