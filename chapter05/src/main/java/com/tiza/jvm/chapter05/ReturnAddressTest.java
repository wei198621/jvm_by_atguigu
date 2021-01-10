package com.tiza.jvm.chapter05;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 * @author leowei
 * @date 2021/1/9  - 8:40
 */
public class ReturnAddressTest {
    public char methodChar(){return  'a';}
    public int methodInt(){return  0;}
    public long methodLong(){return  0L; };
    public float methodFloat(){return 0.0f;}
    public double methodDouble(){ return 0.0;}
    public String methodString(){ return  null;}
    public Date methodDate(){return null;}

    static {
        int i=10;
    }

    public void method2(){
        try {
            method1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method1() throws IOException{
        FileReader fis = new FileReader("leavingTiza.txt");
        char[] cBuffer =new char[1024];
        int len;
        while((len=fis.read(cBuffer)) != -1){
            String str = new String(cBuffer, 0, len);
            System.out.println(str);
        }
        fis.close();
    }
}
