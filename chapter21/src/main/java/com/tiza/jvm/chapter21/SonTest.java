package com.tiza.jvm.chapter21;

/**
 *

 0 aload_0                                             0 是this
 1 invokespecial #1 <java/lang/Object.<init>>         调用构造器，首先调用父类的初始化方法
 4 aload_0
 5 bipush 10
 7 putfield #2 <com/tiza/jvm/chapter21/Father.x>       给x赋值 为 10
 10 aload_0
 11 invokevirtual #3 <com/tiza/jvm/chapter21/Father.print>   打印
 14 aload_0
 15 bipush 20
 17 putfield #2 <com/tiza/jvm/chapter21/Father.x>       给x赋值 为 20
 20 return

 */
class Father{
    int x=10;
    public Father(){
        this.print();
        x=20;
    }

    public void print(){
        System.out.println("Father.x="+x);
    }
}

class Son extends Father{
    int x=30;
    public Son(){
        this.print();
        x=40;
    }
    public void print(){
        System.out.println("Son.x="+x);
    }
}

/**
 * @author leowei
 * @date 2021/1/19  - 7:12
 */
public class SonTest {
    public static void main(String[] args) {
        //m1();
        m2();
        //m3();
    }

    /**
     * 类的非静态成员变量赋值过程
     *  前置1  aload_0   a
     *  前置2  父类初始化
     *  step 1  成员变量  默认初始化   x=0
     *  step 2  成员变量  显示初始化/代码块中初始化  x=10  后打印
     *  step 3  构造器初始化           x=20
     *  step 4  (有了对象后)  对象.属性  赋值
     * 打印内容
     Father.x=10
     20
     */
    private static void m1() {
        Father father = new Father();
        System.out.println(father.x);
    }

    /**
     * new Son  先 new  Father
     Son.x=0
     Son.x=30
     40         --- 属性不存在多态，所以一定是 20
     */
    private static void m2(){
        Son son=new Son();
        System.out.println(son.x);
    }

    /**
     *

     0 aload_0 ---------------------------------------------------- 加载当前 Son  的 this
     1 invokespecial #1 <com/tiza/jvm/chapter21/Father.<init>>  --- 构造器初始化时候，先init 其父类的(Father) 构造器
                                                                --- Father 构造器会执行new Father() 构造器函数中的 this.print()
                                                                --- 此时 Father 类中的  this.print() 中的 this 是 Son  ,所以会打印 Son.x =0 ;
     4 aload_0
     5 bipush 30                                               ---- 注意，此时才赋值30 给X
     7 putfield #2 <com/tiza/jvm/chapter21/Son.x>
     10 aload_0
     11 invokevirtual #3 <com/tiza/jvm/chapter21/Son.print>
     14 aload_0
     15 bipush 40
     17 putfield #2 <com/tiza/jvm/chapter21/Son.x>
     20 return



     Son.x=0
     Son.x=30
     20              --- 属性不存在多态，所以一定是 20
     */
    private static void m3(){
        Father f=new Son();
        System.out.println(f.x);
    }

}
