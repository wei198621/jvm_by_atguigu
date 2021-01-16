package com.tiza.jvm.chapter17;

import java.util.ArrayList;

/**
 * @author leowei
 * @date 2021/1/16  - 23:29
 * -XX:+PrintCommandLineFlags             ----- 1
 * jinfo -flag UseParallelGC 21476        ----- 2
 *
 *
 *
-XX:InitialHeapSize=266089344 -XX:MaxHeapSize=4257429504
-XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops
-XX:-UseLargePagesIndividualAllocation
-XX:+UseParallelGC  ---- 显示使用的 垃圾回收器




C:\Users\wei19>jps
1648
16592
12516 Launcher
19604 Jps
21476 GCUseTest
15576 Main
19560 jprofiler.exe

C:\Users\wei19>jinfo -flag UseParallelGC 21476
-XX:+UseParallelGC

C:\Users\wei19>jinfo -flag UseParallelOldGC 21476
-XX:+UseParallelOldGC

C:\Users\wei19>jinfo -flag UseG1GC 21476
-XX:-UseG1GC

C:\Users\wei19>



 *
 */
public class GCUseTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<byte[]>();
        while (true){
            byte[] arr = new byte[100];
            list.add(arr);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
