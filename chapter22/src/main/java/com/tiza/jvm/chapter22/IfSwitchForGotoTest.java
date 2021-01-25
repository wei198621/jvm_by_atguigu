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

}
