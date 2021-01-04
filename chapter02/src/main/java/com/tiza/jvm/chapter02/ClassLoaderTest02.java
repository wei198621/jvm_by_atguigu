package com.tiza.jvm.chapter02;

import sun.misc.Launcher;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * @author leowei
 * @date 2021/1/5  - 0:12
 */
public class ClassLoaderTest02 {
    public static void main(String[] args) {

        System.out.println("**************  启动类加载器  *************");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urls) {
            System.out.println(element.toExternalForm());
        }

        //从上面路径中随意选择一个类，看看他的类加载器是什么：引导类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);    // null

        System.out.println("************  扩展类加载器  *************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println("path = " + path);
        }

        //从上面路径中随意选择一个类，看看他的类加载器是什么：引导类加载器
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println("classLoader1 = " + classLoader1);    // sun.misc.Launcher$ExtClassLoader@330bedb4

    }
}
