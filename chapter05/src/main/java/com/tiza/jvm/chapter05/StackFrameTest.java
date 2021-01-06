package com.tiza.jvm.chapter05;


/**
 * @author leowei
 * @date 2021/1/6  - 23:01
 */
public class StackFrameTest {
    public static void main(String[] args) {
        StackFrameTest stackTest = new StackFrameTest();
        stackTest.method1();
    }

    // 注意使用 javap -v ***.class 反编译 看效果 ，需要为public 方法，原理未知
    public void method1() {
        System.out.println("method1() 开始执行... ");
        method2();
        System.out.println("method1() 执行结束... ");
    }

    // 注意使用 javap -v ***.class 反编译 看效果 ，需要为public 方法，原理未知
    public int method2() {
        System.out.println("method2() 开始执行... ");
        int i = 10;
        i = (int) method3();
        System.out.println("method2() 执行结束... ");
        return i;
    }
    // 注意使用 javap -v ***.class 反编译 看效果 ，需要为public 方法，原理未知
    public double method3() {
        System.out.println("method3() 开始执行... ");
        double j = 20.0;
        System.out.println("method3() 执行结束... ");
        return j;
    }
}
