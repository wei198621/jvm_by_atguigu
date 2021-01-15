package com.tiza.jvm.str_intern;

/**
 * Author: tz_wl
 * Date: 2021/1/15 16:26
 * Content:
 *
 * jdk 1.8
 *
 * String 的垃圾回收：
 * -Xms15m -Xmx15m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails
 *
 */
public class StringInternGCTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            String.valueOf(i).intern();
            // valueof ()  -->  Integer.toString(i);  -->   return new String(buf, true);
        }
    }
}
