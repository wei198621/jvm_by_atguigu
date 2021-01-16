package com.tiza.jvm.chapter16;

/**
 * @author leowei
 * @date 2021/1/16  - 15:17
 *
 * -XX:+PrintGCDetails
 * https://www.bilibili.com/video/BV1PJ411n7xZ?p=156
 *
 */
public class LocalVarGC {

    public void localVarGC1() {
        //回收不了
        byte[] buffer = new byte[10 * 1024 * 1024];  // 10M
        System.gc();
    }
    public void localVarGC2() {
        byte[] buffer = new byte[10 * 1024 * 1024];
        buffer=null;
        System.gc();
    }

    public void localVarGC3() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024];  //没有被释放掉
        }
        System.gc();
    }
    public void localVarGC4() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        int value=10;  // 由于这步  垃圾被回收
        System.gc();
    }

    public void localVarGC5() {
        localVarGC1();
        System.gc();   //被回收
    }


    public static void main(String[] args) {
        LocalVarGC local = new LocalVarGC();
        local.localVarGC5();
    }
}
