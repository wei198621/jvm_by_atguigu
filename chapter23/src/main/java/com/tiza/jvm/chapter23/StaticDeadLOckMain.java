package com.tiza.jvm.chapter23;

/**
 * @author leowei
 * @date 2021/1/28  - 22:45
 */
public class StaticDeadLOckMain extends Thread {
    private char flag;

    public StaticDeadLOckMain(char flag){
        this.flag=flag;
        this.setName("Thread "+ flag);
    }

    public void run(){
        System.out.println("-------------- start running flag is "+ flag);
        try {
            Class.forName("com.tiza.jvm.chapter23.Static"+flag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(getName());
        System.out.println("-------------- finish running flag is "+ flag);
    }

    // A 调用 B  , B  调用  A 进入死循环
    public static void main(String[] args) {
        StaticDeadLOckMain loadA = new StaticDeadLOckMain('A');
        loadA.start();

        StaticDeadLOckMain loadB = new StaticDeadLOckMain('B');
        loadB.start();
    }

}

// A 加载 B
class StaticA{
    static{
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("com.tiza.jvm.chapter23.StaticB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticA init OK");
    }
}
// B 加载  A
class StaticB{
    static{
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("com.tiza.jvm.chapter23.StaticA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticA init OK");
    }
}
