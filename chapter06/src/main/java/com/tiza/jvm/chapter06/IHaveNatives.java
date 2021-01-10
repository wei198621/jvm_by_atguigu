package com.tiza.jvm.chapter06;

/**
 * @author leowei
 * @date 2021/1/9  - 9:37
 */
public class IHaveNatives {

    public native void Native1(int x);
    public native static long Native2();
    private native synchronized float Native3();
    native void Native4(int[] any) throws Exception;

}
