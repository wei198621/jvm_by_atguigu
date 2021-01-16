package com.tiza.jvm.chapter16;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author leowei
 * @date 2021/1/16  - 21:58
 *
 * 这个里面有详细的过程，太复杂了，没有实操
 * https://www.bilibili.com/video/BV1PJ411n7xZ?p=167
 *
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue<PhantomReferenceTest> phantomQueue = new ReferenceQueue<PhantomReferenceTest>();
        PhantomReferenceTest obj = new PhantomReferenceTest();
        PhantomReference<PhantomReferenceTest> phantomRef = new PhantomReference<PhantomReferenceTest>(obj, phantomQueue);
        phantomRef.get();   //  强软弱虚  虚的什么也取不到数据
    }
}
