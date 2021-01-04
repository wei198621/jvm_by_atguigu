package com.tiza.jvm.chapter02;

/**
 * @author leowei
 * @date 2021/1/4  - 23:22
 */
public class ClassInitTestFatherSon {

    static class Father {
        public static int A=1;

        static {
            A=2;
        }
        static class Son extends Father{
            public static int B =A;
        }
    }


    public static void main(String[] args) {
        //  首先  加载Father类  ，  然后加载Son类
        System.out.println(Father.Son.B);  // 2
    }
}
