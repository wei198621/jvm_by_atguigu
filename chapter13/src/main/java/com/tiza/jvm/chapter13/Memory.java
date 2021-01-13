package com.tiza.jvm.chapter13;

/**
 * @author leowei
 * @date 2021/1/13  - 23:09
 */
public class Memory {
    public static void main(String[] args) {
        int i=1;
        Object obj = new Object();
        Memory mem = new Memory();
        mem.foo(obj);
    }

    private void foo(Object param){
        String str = param.toString();
        System.out.println(str);
    }
}
