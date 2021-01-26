package com.tiza.jvm.chapter22;

/**
 * @author leowei
 * @date 2021/1/25  - 23:57
 */
public class IfSwitchForGotoTest {

    public static void main(String[] args) {

    }

    /** 条件跳转指令

     0 iconst_0
     1 istore_1
     2 iload_1
     3 ifne 12 (+9)
     6 bipush 10
     8 istore_1
     9 goto 15 (+6)
     12 bipush 20
     14 istore_1
     15 return
    */
    public void comapre1(){
        int a=0;
        if (a == 0) {
            a=10;
        }else{
            a=20;
        }
    }

    /**
     0 aload_1
     1 ifnonnull 6 (+5)
     4 iconst_1
     5 ireturn
     6 iconst_0
     7 ireturn

     * @param str
     * @return
     */
    public boolean compareNull(String str){
        if(str==null){
            return true;
        }else{
            return false;
        }
    }

    /**
     0 ldc #2 <9.0>
     2 fstore_1
     3 ldc #3 <10.0>
     5 fstore_2
     6 getstatic #4 <java/lang/System.out>
     9 fload_1
     10 fload_2
     11 fcmpg
     12 ifge 19 (+7)
     15 iconst_1
     16 goto 20 (+4)
     19 iconst_0
     20 invokevirtual #5 <java/io/PrintStream.println>
     23 return

     */
    public void compare2() {
        float f1 = 9;
        float f2=10;
        System.out.println(f1<f2);
    }

    public void compare3(){
        int i1=20;
        int i2=20;
        System.out.println(i1<i2);
    }

    /**
     *
     0 dload_1
     1 ldc2_w #6 <50.0>
     4 dcmpl
     5 ifle 10 (+5)
     8 iconst_1
     9 ireturn
     10 iconst_m1
     11 ireturn

     * @param d
     * @return
     */

    public int compare4(double d){
        if(d>50.0)
            return  1;
        else
            return -1;
    }

    //  比较条件跳转指令

    /**
     0 bipush 10
     2 istore_1
     3 bipush 20
     5 istore_2
     6 getstatic #4 <java/lang/System.out>
     9 iload_1
     10 iload_2
     11 if_icmple 18 (+7)
     14 iconst_1
     15 goto 19 (+4)
     18 iconst_0
     19 invokevirtual #5 <java/io/PrintStream.println>
     22 return

     */
    public  void ifCompare1(){
        int i=10;
        int j=20;
        System.out.println(i>j);
    }

    public void ifCompare2(){
        short s1=9;
        byte b1=10;
        System.out.println(s1>b1);
    }

    public void ifCompare3(){
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1==obj2);
        System.out.println(obj1!=obj2);
    }

    //  switch test   多条件分支跳转

    /**
     0 iload_1
     1 tableswitch 1 to 3	1:  28 (+27)
     2:  34 (+33)
     3:  40 (+39)
     default:  46 (+45)
     28 bipush 10
     30 istore_2
     31 goto 49 (+18)
     34 bipush 20
     36 istore_2
     37 goto 49 (+12)
     40 bipush 30
     42 istore_2
     43 goto 49 (+6)
     46 bipush 40
     48 istore_2
     49 return

     * @param select
     */

    public void switch1(int select){
        int num;
        switch (select) {
            case 1:
                num = 10;
                break;
            case 2:
                num = 20;
                break;
            case 3:
                num = 30;
                break;
            default:
                num = 40;
        }
    }


    /**
     0 iload_1
     1 lookupswitch 3
     100:  36 (+35)
     200:  48 (+47)
     500:  42 (+41)
     default:  54 (+53)
     36 bipush 10
     ... ...
     * @param select
     */
    public void switch2(int select){
        int num;
        switch (select) {
            case 100:
                num = 10;
                break;
            case 500:
                num = 20;
                break;
            case 200:
                num = 30;
                break;
            default:
                num = 40;
        }
    }

    //JDK 7 新特性： 引入String 类型

    /**
     0 aload_1
     1 astore_2
     2 iconst_m1
     3 istore_3
     4 aload_2
     5 invokevirtual #9 <java/lang/String.hashCode>
     8 lookupswitch 4
     -1842350579:  52 (+44)
     -1837878353:  66 (+58)
     -1734407483:  94 (+86)
     1941980694:  80 (+72)
     default:  105 (+97)
     52 aload_2
     ...
     * @param season
     */
    public void switch3(String season){
        switch(season){
            case "SPRING": break;
            case "SUMMER": break;
            case "AUTUMN": break;
            case "WINTER": break;
        }
    }


    // 4 无条件跳转指令

    /**
     0 dconst_0
     1 dstore_1
     2 dload_1
     3 ldc2_w #16 <100.1>
     6 dcmpg
     7 ifge 20 (+13)
     10 ldc #15 <atguigu.com>
     12 astore_3
     13 dload_1
     14 dconst_1
     15 dadd
     16 dstore_1
     17 goto 2 (-15)  ------------goto 指令
     20 return

     */
    public void whileInt(){
        int i=0;
        while(i<100){
            String s="atguigu.com";
            i++;
        }
    }

    public void whileDouble(){
        double d=0.0;
        while(d<100.1){
            String s="atguigu.com";
            d++;
        }
    }

    public void printFor(){
        short i;
        for (i = 0; i < 100; i++) {
            String s="atguigu.com";
        }
    }


    public void whileTest(){
        int i=1;
        while(i<=100){
            i++;
        }
    }

    public void forTest(){
        for (int i = 0; i < 100; i++) {

        }
    }

    public void doWhileTest(){
        int i=1;
        do{
            i++;
        }while (i<=100);
    }

}
