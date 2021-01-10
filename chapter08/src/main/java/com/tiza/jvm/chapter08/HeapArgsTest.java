package com.tiza.jvm.chapter08;

/**
 * @author leowei
 * @date 2021/1/10  - 10:28
 *
 * 官网说明：
https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
堆空间中常用参数
>-XX:+PrintFlagsInitial  查看所有参数的默认初始值
>-XX:+PrintFlagsFinal      查看所有参数的最终值
具体查看某个参数的指令    jps: 查看当前运行的进程
                        如: jinfo -flag SurvivorRatio 进程ID
>-Xms:初始堆空间内存           物理内存的 1/64
>-Xmx:最大堆空间内存          物理内存的 1/4
>-Xmn:设置新生代内存大小
>-XX:NewRatio:    配置新生代与老年代在堆结构中的比例
>-XX:SurvivorRatio:                             设置新生代Eden vs  S0/s1  空间的比例
>-XX:MaxTenuringThreshold              设置新生代垃圾的最大年龄
>-XX:+PrintGCDetails:                    输出详细GC处理日志
>打印GC 简要信息          -XX:+PrintGC            -verbose:gc
>-XX:HandlePromotionFailure:        是否设置空间分配担保  JDK7 以后，此参数一直是true
 *
 *
 *
 */
public class HeapArgsTest {
    public static void main(String[] args) {
        while (true){

            System.out.println("args = " + args);
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
