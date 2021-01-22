package com.tiza.jvm.chapter22;

import org.junit.Test;

/**
 * @author leowei
 * @date 2021/1/22  - 22:23
 */
public class ArithmeticTest {
    @Test
    public void method1(){
        int i=10;
        double j =i/0.0;
        System.out.println(j);  // 无穷大  Infinity


        double d1=0.0;
        double d2=d1/0.0;
        System.out.println(d2);  //  NaN  : not a number
    }

    // 下面几个方法  编译后看代码
    public void method2(){
        float i=10;
        float j=-i;
        i=-j;
    }

    public void method3_1(){
        int i=100;
        i=i+10;
    }
    public void method3_2(){
        int i=100;
        i+=10;
    }

    public int method4(){
        int a=80;
        int b=7;
        int c=10;
        return (a+b)*c;

    }

    public  int method5(int i,int j) {
        return ((i + j - 1) & (j - 1));
    }

    public void method6_1(){
        int i=10;
        i++;
    }
    public void method6_2(){
        int i=10;
        ++i;
    }
}
