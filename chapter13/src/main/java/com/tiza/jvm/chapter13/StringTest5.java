package com.tiza.jvm.chapter13;

import org.junit.Test;

/**
 * @author leowei
 * @date 2021/1/13  - 23:28
 */
public class StringTest5 {

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        StringTest5 stringTest5 = new StringTest5();
       // stringTest5.methodByString(100000);              //用时： 5174
        stringTest5.methodByStringBuilder(100000);  //用时：  4
        long timeEnd = System.currentTimeMillis();
        System.out.println("用时："+ (timeEnd-timeStart));
    }

    @Test
    public void test2(){
        String s1="javaEE";
        String s2="hadoop";
        String s3="javaEEhadoop";
        String s4="javaEE"+ "hadoop";   // 编译期 优化
        String s5=s1+"hadoop";         // 如果拼接字符串出现变量 ，相当于在堆空间New String（）
        String s6="javaEE"+ s2;
        String s7=s1+s2;

        System.out.println(s3==s4);  // true
        System.out.println(s3==s5);  // 只要有变量就放在（非字符串常量池的）堆中 所以 false
        System.out.println(s3==s6);  // false 同上
        System.out.println(s3==s7);   // false 同上
        System.out.println(s5==s6); // false 同上
        System.out.println(s5==s7); // false 同上
        System.out.println(s6==s7); // false 同上

        System.out.println("----------------------");
        // intern 判断字符串常量池中是否存在 javaEEhadoop ，如果存在，返回常量池中javaEEhadoop的地址
        //如果字符串常量池中不存在javaEEhadoop，则在常量池中加载一份，并返回此此对象的地址
        String s8 = s6.intern();    //放到字符串常量池中
        System.out.println(s3==s8);  //true

        System.out.println("=====================");
        String str1="a";
        String str2="b";
        String str3="ab";
        String str4= s1+s2;
        String str5= "a"+"b";
        System.out.println( str3==str4);   // false   str3 放在字符串常量表   str4 放在堆空间
        System.out.println( str3==str5);   // true     str5 在编译时候 自动变为  "ab" ;

    }

    @Test
    public void test41(){
         String s1="a";
         String s2="b";
        String s3="ab";
        String s4=s1+s2;    // s4 相当于 new StringBuild().append("a").append("b");
        System.out.println(s3==s4);  //false
    }

    /*
    字符串拼接操作不一定使用StringBuilder
    如果拼接符号左右两边都是字符串常量或者常量引用 ，则仍然使用编译期优化，即非StringBuilder的方式
     */
    /*
    final 说明 1
    1.final 修饰类    类不可以被继承
    1.final 修饰方法  方法不可以被重写
    1.final 修饰变量  变量变成常量
     */
    @Test
    public void test42(){
        final String s1="a";       // final 定义的不能当做变量看，要当做常量看
        final String s2="b";
        String s3="ab";
        String s4=s1+s2;            // s4 相当于  "a" + "b"
        System.out.println(s3==s4);   //true
    }

    @Test
    public void test43(){
        String s1="javaEEhadoop";
        final String s4="javaEE";
        String s5 =s4+"hadoop";
        System.out.println(s1==s5);  // true   s4 用final 修饰，相当于 是个常量了
    }

    public void methodByString(int times){
        String str="";
        for (int i = 0; i < times; i++) {
            str= str+ "a";  // 每次循环都创建一个StringBuilder
        }
    }


    public void methodByStringBuilder(int times){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < times; i++) {
            str.append("a");
        }
    }


}





