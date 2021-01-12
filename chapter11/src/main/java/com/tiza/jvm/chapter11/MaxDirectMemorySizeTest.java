package com.tiza.jvm.chapter11;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * -Xmx20m -XX:MaxDirectMemorySize=10m
 *
 * @author leowei
 * @date 2021/1/12  - 21:49
 *
 * java.lang.OutOfMemoryError
 */
public class MaxDirectMemorySizeTest {
    private static final long _1MB = 1024 * 1024;
    public static void main(String[] args) throws IllegalAccessException{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
