package com.tiza.jvm.chapter21;

/**
 * @author leowei
 * @date 2021/1/18  - 23:33
 */
public class IntegerTest {
    public static void main(String[] args) {
        m1();
        m2();
        m3();
    }

    /**
     *
     0 bipush 10
     2 invokestatic #5 <java/lang/Integer.valueOf>
     5 astore_0
     6 bipush 10
     8 invokestatic #5 <java/lang/Integer.valueOf>
     11 astore_1
     12 getstatic #6 <java/lang/System.out>
     15 aload_0
     16 aload_1
     17 if_acmpne 24 (+7)
     20 iconst_1
     21 goto 25 (+4)
     24 iconst_0
     25 invokevirtual #7 <java/io/PrintStream.println>
     28 return

     通过查看字节码文件，看到i1  i2 取值的时候会调用valueOf方法，
     如下所示valueOf 方法 会从一个cache 中取数据
     Cache 的值 在 -128~127 之间
     所以取 -128 ~ 127 之间的数字，不会新建空间，调用cache中的空间就可以了

     * @since  1.5
    public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }

     这解释了  m1  m2  连个问题

     */
    private static void m1() {
        Integer i1=10;
        Integer i2=10;
        System.out.println(i1==i2);  //true
    }


    private static void m2() {
        Integer i3=128;
        Integer i4=128;
        System.out.println(i3==i4);   //false
    }

    /**
     *
     0 iconst_5
     1 invokestatic #5 <java/lang/Integer.valueOf>
     4 astore_0
     5 iconst_5
     6 istore_1
     7 getstatic #6 <java/lang/System.out>
     10 aload_0
     11 invokevirtual #8 <java/lang/Integer.intValue>
     14 iload_1
     15 if_icmpne 22 (+7)
     18 iconst_1
     19 goto 23 (+4)
     22 iconst_0
     23 invokevirtual #7 <java/io/PrintStream.println>
     26 return
     此处涉及自动装箱拆箱，暂时没有搞懂此时是装箱还是拆箱  20210118
     */
    private static void m3() {
        Integer x=5;
        int y=5;
        System.out.println(x==y);    //true
    }
}
