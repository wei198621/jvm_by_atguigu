package com.tiza.jvm.chapter08;

/**
 *  大对象直接进入老年代
 * -Xms60m -Xmx60m -XX:+PrintGCDetails -XX:NewRatio=2 -XX:SurvivorRatio=8
 *
 * 经过上述参数配置后
 * E  S0  S1   O
 * 16 2  2    40
 * @author leowei
 * @date 2021/1/10  - 9:45
 */
public class YoungOldAreaTest {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024 * 1024 * 20];
    }
}
