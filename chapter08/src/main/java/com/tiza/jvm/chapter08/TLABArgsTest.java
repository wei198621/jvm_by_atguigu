package com.tiza.jvm.chapter08;

/**
 *
 * -XX:UseTLAB
 *
 C:\Users\wei19>jps
 2464
 5904 Jps
 96 RemoteMavenServer
 10088 TLABArgsTest
 14360 Launcher

 C:\Users\wei19>jinfo -flag UseTLAB 10088
 -XX:+UseTLAB                ---  表示使用了 TLAB
 *
 *
 * @author leowei
 * @date 2021/1/10  - 10:05
 */
public class TLABArgsTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("111");
        Thread.sleep(1000000);
    }

}
