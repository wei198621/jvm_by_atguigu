package com.tiza.jvm.chapter22;

import java.io.IOException;

/**
 * @author leowei
 * @date 2021/1/26  - 22:53
 */
public class ExceptionTest {
    public static void main(String[] args) {

    }

    public void throwZero(int i){
        if(i==0){
            throw new RuntimeException("sss");
        }
    }

    public void throwOne(int i) throws RuntimeException,IOException{
        if(i==1){
            throw new RuntimeException("sss");
        }
    }

    public void throwArithmetic(){
        int i=10;
        int j=i/0;
        System.out.println(j);
    }
}
