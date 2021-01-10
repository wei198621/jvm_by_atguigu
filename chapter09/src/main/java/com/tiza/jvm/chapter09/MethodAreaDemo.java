package com.tiza.jvm.chapter09;
/**
 *
 * @author leowei
 * @date 2021/1/10  - 14:11
 *
 * 其他操作都不做，就打开jkd  bin 下面的Visual VM  ,
 * 查看 监视 选项卡 看 实体个数
 *
 *
 * jdk7
 * -XX:PermSize=100m -XX:MaxPermSize=100m
 *
 * jdk8
 * -XX:MetaspaceSize=100m   -XX:MaxMetaspaceSize=100m
 *
 *
 */
public class MethodAreaDemo {
    public static void main(String[] args) {
        System.out.println("start ... ");
       /* try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("end ...");
    }
}
