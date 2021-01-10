package com.tiza.jvm.chapter08;

import javax.swing.text.SimpleAttributeSet;
import java.security.Provider;

/**
 * @author leowei
 * @date 2021/1/10  - 13:12
 *
 * -XX:+EliminateAllocations:    开启标量替换，默认是开启的，允许将对象打散分配在栈上。
 * -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 */
public class ScalarTest {
    public static void main(String[] args) {
        ScalarTest cls =new ScalarTest();
        cls.alloc();
    }
    /*
    标量替换是指，在JIT阶段，如果经过逃逸分析，发现一个对象不会被外界访问，
    经过JIT优化后，把此对象拆解为若干成员变量来代替，这个过程就是标量替换
    所以alloc函数优化后的效果如图所示
    private void alloc(){
        int x=1;
        int y=2;
        System.out.println(point.x + "; "+ point.y);
     }
     */
    private  void alloc(){
        Point point = new Point(1, 2);    // point 未发生逃逸
        System.out.println(point.x + "; "+ point.y);
    }

    class Point{
        private int x;
        private int y;
        Point(int x,int y){
            this.x =x;
            this.y =y;
        }
    }
}
