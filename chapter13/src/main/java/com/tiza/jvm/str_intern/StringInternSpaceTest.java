package com.tiza.jvm.str_intern;

/**
 * Author: tz_wl
 * Date: 2021/1/15 15:29
 * Content:  使用intern 测试执行效率
 *
 * 使用jvisualvm 查看  抽样器  内存
 * 使用jprofiler 进行测试
 *
 * 结论：  对于程序中大量存在的字符串， 尤其存在很多偿付字符串时候，
 * 使用intern() ,会节约很多的JVM 中 堆 中间的空间
 *
 */
public class StringInternSpaceTest {

    static final int MAX_COUNT = 1000 * 10000;    //  1000万
    static final String[] arr =new String[MAX_COUNT];

    public static void main(String[] args) {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_COUNT; i++) {
            //arr[i] = new String(String.valueOf(data[i % data.length]));          //用时：7075
            arr[i]= new String(String.valueOf(data[i%data.length])).intern();     //用时：2280
            // **.intern() ;  创建空间后销毁了
        }
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-start));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
