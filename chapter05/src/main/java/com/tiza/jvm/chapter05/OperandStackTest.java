package com.tiza.jvm.chapter05;

/**
 * @author leowei
 * @date 2021/1/8  - 21:56
 */
public class OperandStackTest {

    public void testAddOperation(){
        // byte / short / chart /boolean 都是以Int 来保存的
        byte i=15;
        int j=8;
        int k=i+j;
    }

    public int GetSum(){
        int m=10;
        int n=20;
        int k =m+n;
        return k;
    }

    public void testGetSum(){
        int i=GetSum();
        int j=10;
    }


    // i++    ++i
    public void add(){
        // 第一类问题
        int i1=10;
        i1++;

        int i2=10;
        ++i2;

        // 第二类问题
        int i3=10;
        int i4=i3++;

        int i5=10;
        int i6=++i5;

        // 第三类问题
        int i7=10;
        i7=i7++;

        int i8=10;
        i8=++i8;
        //第四类问题
        int i9=10;
        int i10 =i9++ + ++i9;





    }

}
