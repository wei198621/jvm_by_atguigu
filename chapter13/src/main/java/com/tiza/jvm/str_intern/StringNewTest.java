package com.tiza.jvm.str_intern;

/**
 * @author leowei
 * @date 2021/1/15  - 7:26
 * String str = new String("ab");
 * new String("ab") 会创建几个对象？
 *     两个对象 一个是：new 关键字在堆空间创建的
 *              另一个是 字符串常量池中的对象
 *
 *
 *  String strPlus =new String("a")+ new String("b"); 创建了几个对象？
 *  对象1：  new StringBuilder()    只要有拼接，就要有StringBuilder
 *  对象2：  new String("a");
 *  对象3：  常量池中的"a" ;
 *  对象4：  new String("b");
 *  对象5：  常量池中的"b" ;
 *  深入剖析 StringBuilder 的 toString()
 *      对象6  new String("ab");
 *      强调一下，toString() 的调用，在字符串常量池中没有 ab  {正常new String()做两步，1堆分配，2字符串常量池分配}
 */
public class StringNewTest {
    public static void main(String[] args) {

    /*
     0 new #2 <java/lang/String>   堆空间开辟一个对象用于存放对象
     3 dup
     4 ldc #3 <ab>                 “ab”放入 常量池中
     6 invokespecial #4 <java/lang/String.<init>>
     9 astore_1                  将堆空间中的"ab"地址，交给栈中的 str
     10 return
     */
     //String str = new String("ab");


     /*
                0 new #2 <java/lang/StringBuilder>
                3 dup
                4 invokespecial #3 <java/lang/StringBuilder.<init>>
                7 new #4 <java/lang/String>
                10 dup
                11 ldc #5 <a>                     ------   ldc  字符串常量池中分配
                13 invokespecial #6 <java/lang/String.<init>>
                16 invokevirtual #7 <java/lang/StringBuilder.append>
                19 new #4 <java/lang/String>
                22 dup
                23 ldc #8 <b>                     ------  ldc  字符串常量池中分配
                25 invokespecial #6 <java/lang/String.<init>>
                28 invokevirtual #7 <java/lang/StringBuilder.append>
                31 invokevirtual #9 <java/lang/StringBuilder.toString>
                34 astore_1
                35 return
                */

        String strPlus =new String("a")+ new String("b");
    }
}
