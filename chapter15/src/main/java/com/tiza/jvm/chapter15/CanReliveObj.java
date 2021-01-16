package com.tiza.jvm.chapter15;

/**
 * @author leowei
 * @date 2021/1/16  - 9:21
 */
public class CanReliveObj {
    private static CanReliveObj obj;

    //注释，或者取消注释，看看打印的区别
    // finalizer 只能执行一次
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("重写finalize()方法");
        obj =this;
    }

    public static void main(String[] args) {
        obj =new CanReliveObj();

        try {
            //对象第一次删除空自己
            obj=null;
            System.gc();
            System.out.println(" first time doing gc");
            //finalizer线程的优先级比较低，暂停2秒，等待它被执行
            Thread.sleep(2000);

            if(obj==null){
                System.out.println("obj is dead ");
            }else {
                System.out.println("obj is still alive");
            }
            //对象第二次删除空自己
            obj=null;
            System.gc();
            System.out.println(" second time doing gc ");
            if(obj==null){
                System.out.println("obj is dead ");
            }else {
                System.out.println("obj is still alive");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
