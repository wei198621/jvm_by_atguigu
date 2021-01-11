package com.tiza.jvm.chapter09;

/**
 * @author leowei
 * @date 2021/1/11  - 23:19
 *
 * jdk6  jdk7
 * -Xms200m -Xmx200m -XX:PermSize=300m -XX:MaxPermSize=300m -XX:+PrintGCDetails
 *
 * jdk8
 * -Xms200m -Xmx200m -XX:MetaspaceSize=300m -XX:MaxMetaspaceSize=300m -XX:+PrintGCDetails
 *
 * 这块只能证明new 的 大数据放在了堆空间的老年代
 */
public class StaticFieldTest {

    private static byte[] arr=new byte[1024*1024*100];  // 100MB

    public static void main(String[] args) {
        System.out.println( StaticFieldTest.arr);
    }

    /*    JDK 6  7   打印结果   ----数据放在了   ParOldGen  这个空间内

    Heap
 PSYoungGen      total 59712K, used 3072K [0x00000000fbd60000, 0x0000000100000000, 0x0000000100000000)
  eden space 51200K, 6% used [0x00000000fbd60000,0x00000000fc0600a0,0x00000000fef60000)
  from space 8512K, 0% used [0x00000000ff7b0000,0x00000000ff7b0000,0x0000000100000000)
  to   space 8512K, 0% used [0x00000000fef60000,0x00000000fef60000,0x00000000ff7b0000)
 PSOldGen        total 136576K, used 102400K [0x00000000f3800000, 0x00000000fbd60000, 0x00000000fbd60000)
  object space 136576K, 74% used [0x00000000f3800000,0x00000000f9c00010,0x00000000fbd60000)
 PSPermGen       total 307200K, used 3814K [0x00000000e0c00000, 0x00000000f3800000, 0x00000000f3800000)
  object space 307200K, 1% used [0x00000000e0c00000,0x00000000e0fb98e0,0x00000000f3800000)
  */

  /*    JDK 8 打印结果   ----数据放在了   ParOldGen  这个空间内
  Heap
 PSYoungGen      total 59904K, used 6206K [0x00000000fbd80000, 0x0000000100000000, 0x0000000100000000)
  eden space 51712K, 12% used [0x00000000fbd80000,0x00000000fc38f8c8,0x00000000ff000000)
  from space 8192K, 0% used [0x00000000ff800000,0x00000000ff800000,0x0000000100000000)
  to   space 8192K, 0% used [0x00000000ff000000,0x00000000ff000000,0x00000000ff800000)
 ParOldGen       total 136704K, used 102400K [0x00000000f3800000, 0x00000000fbd80000, 0x00000000fbd80000)
  object space 136704K, 74% used [0x00000000f3800000,0x00000000f9c00010,0x00000000fbd80000)
 Metaspace       used 3333K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 358K, capacity 388K, committed 512K, reserved 1048576K
    */
}
