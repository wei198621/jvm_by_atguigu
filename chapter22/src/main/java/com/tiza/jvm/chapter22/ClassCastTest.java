package com.tiza.jvm.chapter22;

import com.sun.xml.internal.fastinfoset.stax.factory.StAXOutputFactory;

/**
 * @author leowei
 * @date 2021/1/22  - 23:19
 */
public class ClassCastTest {

    public void upCast1(){
        int i=10;
        long l=i;
        float f=i;
        double d=i;


        float f2 =1;
        double d2 =l;

        double d3 =f2;

    }

    // 精度损失示例
    public void upCAst2(){
        int i=123123123;
        float  f=i;
        System.out.println(f) ;  //  123123120


        long l=123123123123L;
        //long l=123123123123123123L;   // 这个转换会丢失
        double d=l;
        System.out.println("d = " + d);
    }
    //  针对 byte,short  转换为 long 等 ， 把 byte 看做int 类型
    public void upCast3(byte b){
        int i=b;
        long l=b;
        double d=b;
    }

    //  针对 byte,short  转换为 long 等 ， 把 byte 看做int 类型
    public void upCast4(short s){
        int i=s;
        long l=s;
        double d=s;
    }



    // 窄化类型转化
    public void downCast1(){
        int i=10;
        byte b =(byte) i;
        short s= (short) i;
        char c = (char) i;
        long l=10;
        int i2= (int) l;
        byte b2= (byte) l;
    }

    public void downCast2(){
        float f=10;
        long l = (long) f;
        int i = (int) f;
        byte b = (byte) f;

        double d=10;
        byte b2 = (byte) d;
    }

    public void downCast3(){
        short s=10;
        byte b= (byte) s;
    }

    //  窄化类型转换的精度损失问题
    public void downCast4(){
        int i=128;
        byte b = (byte) i;
        System.out.println("b = " + b);  //  -128
    }

    //  测试 NaN   无穷大
    public void downCast5(){
        double d1 =Double.NaN;   //  0.0/ 0.0  就是  NaN
        int i= (int) d1;
        System.out.println(d1); // NaN
        System.out.println(i);  // 0

        double d2 = Double.POSITIVE_INFINITY;  //POSITIVE_INFINITY = 1.0 / 0.0;
        // double d5 = Double.NEGATIVE_INFINITY; //   NEGATIVE_INFINITY = -1.0 / 0.0;
        long l = (long) d2;
        System.out.println(l);
        System.out.println(Long.MAX_VALUE);

        int j = (int) d2;
        System.out.println(j);
        System.out.println(Integer.MAX_VALUE);

        float f = (float)d2;
        System.out.println(f);
        System.out.println(Float.MAX_VALUE);

    }

}
