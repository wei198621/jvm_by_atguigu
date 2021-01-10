package com.tiza.jvm.chapter08;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 *                      打印垃圾回收细节
 * @author leowei
 * @date 2021/1/9  - 12:26
 */
public class SimpleHeap {
    private int id;
    public SimpleHeap(int id){
        this.id=id;
    }

    public void show(){
        System.out.println("My Id is :"+ id);
    }

    public static void main(String[] args) {
        SimpleHeap s1 = new SimpleHeap(1);
        SimpleHeap s2 = new SimpleHeap(2);

     /*   try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        int[] arr =new int[10];
        Object[] arr2 = new Object[10];
    }

}
