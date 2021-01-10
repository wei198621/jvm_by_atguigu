package com.tiza.jvm.chapter09;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author leowei
 * @date 2021/1/10  - 21:06
 *
 *
 * jdk7
 * -XX:PermSize=100m -XX:MaxPermSize=100m
 *
 * jdk8
 * -XX:MetaspaceSize=100m   -XX:MaxMetaspaceSize=100m
 *
 *
 * 没有COPY成功，原因未知
 * https://www.bilibili.com/video/BV1PJ411n7xZ?p=91
 *
 */
public class OOMTest {
    public static void main(String[] args) {
        int j=0;
        try {
            OOMTest test =new OOMTest();
            for (int i = 0; i < 10000; i++) {
                ClassWriter classWriter = new ClassWriter(0);
                //(知名版本号，修饰符，包名,签名 ，父类，接口
                //classWriter.visit(Opcodes.V1_7,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
                classWriter.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
                //返回byte[]
                byte[] code = classWriter.toByteArray();
              //  test.defineClass("class"+i,code,0,code.length);   // 少此步运行不起来
            }
        }finally {
            System.out.println(j);
        }
    }
}
