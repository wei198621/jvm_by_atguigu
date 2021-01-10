package com.tiza.jvm.chapter05;

import java.util.Date;

/**
 * @author leowei
 * @date 2021/1/7  - 22:47
 */
public class LocalVariablesTest {
    private int count=0;
    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num=10;
        test.test1();

    }
    public LocalVariablesTest(){

    }



    public void test1(){
        Date date = new Date();
        String name1 = "atguigu.com";
        test2(date,name1);   //String info=
        System.out.println(date+name1);
    }

    public String test2(Date dateP,String name2){
        dateP =null;
        name2="songhongkang";
        double weight =130.5;
        char gendar ='男';
        return name2;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //变量c，使用的是之前已经销毁的变量b占据的slot的位置
        int c = a + 1;
    }

}
