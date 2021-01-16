package com.tiza.jvm.chapter15;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author leowei
 * @date 2021/1/16  - 10:31
 */
public class GCRootTest {
    public static void main(String[] args) {
        List<Object> numList= new ArrayList<Object>();
        Date birth = new Date();
        for (int i = 0; i < 100; i++) {
            numList.add(String.valueOf(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据添加完毕，请操作");
        new Scanner(System.in).next();


        numList=null;
        birth=null;
        System.out.println("numList,birth is null ，pls  do it ");
        new Scanner(System.in).next();

        System.out.println("结束");
    }
}
