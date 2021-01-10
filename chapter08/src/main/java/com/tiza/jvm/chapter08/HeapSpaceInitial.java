package com.tiza.jvm.chapter08;


/**
 * @author leowei
 * @date 2021/1/9  - 14:08
 * 默认物理内存的   1/64
默认物理内存的    1/4
 *
 */
public class HeapSpaceInitial {
    public static void main(String[] args) {
          long initialMemory =  Runtime.getRuntime().totalMemory()/1024/1024 ;
          long maxMemory = Runtime.getRuntime().maxMemory()/1024/1024;

        System.out.println("-Xms:" + initialMemory+ "M");
        System.out.println("-Xmx:" + maxMemory+ "M");

        System.out.println("系统内存大小为： " + initialMemory * 64.0 /1024 + "G");
        System.out.println("系统内存大小为： " + maxMemory * 4.0 /1024 + "G");

     /*
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
