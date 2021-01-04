package com.tiza.jvm.chapter02;

/**
 * @author leowei
 * @date 2021/1/4  - 23:29
 */
public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName()+ "开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName()+ "结束");
        };
        Thread t1 = new Thread(r, "thread1");
        Thread t2 = new Thread(r, "thread2");
        t1.start();
        t2.start();
        // 同步加锁   线程1   线程2   都启动，但是一个线程一直调用while 出不来， 第二个线程无法进入执行。
    }
}

// 一直执行 while 块
class DeadThread{
    static{
        if(true){
            System.out.println(Thread.currentThread().getName()+ "初始化当前类");
            while(true){

            }
        }
    }
}
