package com.tiza.jvm.str_intern;

/**
 * @author leowei
 * @date 2021/1/15  - 7:26
 * String str = new String("ab");
 * new String("ab") 会创建几个对象？
 *     两个对象 一个是：new 关键字在堆空间创建的
 *              另一个是 字符串常量池中的对象
 *
 *  String strPlus =new String("a")+ new String("b"); 创建了几个对象？
 *  对象1：  new StringBuilder()
 *  对象2：   new String("a");
 *  对象3：  常量池中的"a" ;
 *  对象4：   new String("b");
 *  对象5：  常量池中的"b" ;
 *  深入剖析 StringBuilder 的 toString()
 *      对象6  new String("ab");
 *      强调一下，toString() 的调用，在字符串常量池中没有 ab
 */
public class StringNewTest {
    public static void main(String[] args) {
      /*  String str = new String("ab");*/
        String strPlus =new String("a")+ new String("b");
    }
}
