package com.tiza.jvm.chapter13;

import java.util.HashSet;
import java.util.Set;

/**
 * jdk6中
 * -XX:PermSize=6m  -XX:MaxPermSize=6m -Xms6m -Xmx6m
 *  java.lang.OutOfMemoryError: PermGen space
 *
 * jdk7 8 中
 * -XX:MetaspaceSize=6m -XX:MaxMetaspaceSize=6m -Xms6m -Xmx6m
 *java.lang.OutOfMemoryError: GC overhead limit exceeded
 *
 * @author leowei
 * @date 2021/1/13  - 22:39
 */
public class StringTest3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        short i=0;
        while (true){
            set.add(String.valueOf(i++).intern());   //intern()  在字符串常量池中分配
        }
    }
}
