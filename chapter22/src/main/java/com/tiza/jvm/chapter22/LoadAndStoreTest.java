package com.tiza.jvm.chapter22;

/**
 * @author leowei
 * @date 2021/1/22  - 21:13
 */
public class LoadAndStoreTest {
    //局部变量压栈指令
    public void load(int num,Object obj,long count,boolean flag,short[] arr){
        System.out.println(num);
        System.out.println(obj);
        System.out.println(count);
        System.out.println(flag);
        System.out.println(arr);
    }

    //常量入栈指令
    public void pushConstLdc(){
        int i=-1;
        int a=5;
        int b=6;
        int c=127;
        int d=128;
        int e=1234567;
    }

    //出栈 装入局部变量表指令
    public void store(int k, double d){
        int m=k+2;
        long l =12;
        String str="atguigu";
        float f=10.0F;
        d =10;
    }

}
