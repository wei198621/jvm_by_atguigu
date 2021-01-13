package com.tiza.jvm.chapter13;

/**
 * @author leowei
 * @date 2021/1/13  - 22:03
 */
public class StringExer {

    String str=new String("good");    //  String str="good";   //new 及 字面量方式都一样
    char[] ch ={'t','e','s','t'};

    public void change(String str,char[] ch){
        str ="test ok";
        ch[0] ='b';
    }

    public static void main(String[] args) {
        StringExer ex = new StringExer();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);  // good        考察的是string的不可变性  （20210113没有彻底理解，需要再研究）
        System.out.println(ex.ch);   //best
    }
}
