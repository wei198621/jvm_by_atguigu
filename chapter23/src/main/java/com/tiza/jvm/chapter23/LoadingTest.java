package com.tiza.jvm.chapter23;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author leowei
 * @date 2021/1/27  - 22:56
 */
public class LoadingTest {
    public static void main(String[] args) {

        try {
            Class clazz = Class.forName("java.lang.String");
            //获取当前运行时类声明的所有方法
            Method[] ms = clazz.getDeclaredMethods();
            for (Method m : ms) {
                //获取方法的修饰符
                String mod = Modifier.toString(m.getModifiers());
                System.out.print("mod = " + mod);
                //获取方法的返回值类型
                String returnType = m.getReturnType().getSimpleName();
                System.out.print("returnType = " + returnType);
                //获取方法名
                System.out.print(m.getName()+ "(");
                //获取方法的参数列表
                Class<?>[] ps = m.getParameterTypes();
                if(ps.length==0){
                    System.out.print(")");
                }
                for (int i = 0; i < ps.length; i++) {
                    char end = (i==ps.length-1)? ')':',';
                    System.out.print(ps[i].getSimpleName() + end);
                }
                System.out.println();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
