package com.tiza.jvm.chapter23;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author leowei
 * @date 2021/1/28  - 23:22


1.  创建一个类的实例时
1.1  new  ***
1.2   反射，克隆，反序列化
2.  当调用类的静态方法时 ，即当使用了字节码invokestatic指令。
3.  当使用类、接口的静态字段时(final修饰特殊考虑)。


4. 当使用java.lang.reflect包中的方法反射类的方法时。 比如Class.forName("com.tiza.java.Test")
5. 当初始化子类时，如果发现其父类没有初始化，需要先触发其父类的初始化
（
java虚拟机初始化一个类的时候，要求他的所有父类都已经被初始化，这条规则不适用于接口
5.1  初始化一个类时，并不会先初始化它所实现的接口
5.2  初始化一个接口时，并不会先初始化他的父接口
5.3  一个父接口不会因为它的子接口或者实现类的初始化而初始化。只有当程序首次使用特定接口的静态字段时，
才导致该接口被初始化
）

6. 如果一个接口定义了default方法，那么直接或者间接实现接口的类的初始化时候，改接口在其之前被初始化
7. 虚拟机启动时候，执行一个包含main方法的类。
8.初次调用MethodHandle实例时，初始化改MethodHandle指向的方法所在的类。

 */
public class ActiveUse1 {

//    1.  创建一个类的实例时
//    1.1  new  ***
//    1.2   反射，克隆，反序列化
    public static void main(String[] args) {
        Order order = new Order();
    }


    @Test
    public void test1() {
        ObjectOutputStream oos=null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("order.dat"));
            oos.writeObject(new Order());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2(){
        ObjectInputStream ois=null;
        try {
            ois = new ObjectInputStream(new FileInputStream("order.dat"));
            Order order = (Order) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ois !=null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //2  当调用类的静态方法时 ，即当使用了字节码invokestatic指令。
//    Order 类的初始化过程
//    order method() ....

    @Test
    public void test3(){
        Order.method1();
    }


}

class Order implements Serializable{
    static {
        System.out.println("Order 类的初始化过程");
    }

    public static void method1(){
        System.out.println("order method() .... ");
    }
}

