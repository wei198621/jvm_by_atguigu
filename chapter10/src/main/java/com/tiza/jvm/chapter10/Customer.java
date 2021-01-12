package com.tiza.jvm.chapter10;

/**
 * @author leowei
 * @date 2021/1/12  - 20:37
 */
public class Customer {

    int id=1001;
    String name;           // 字符串常量   jdk7 以后 ，放在 堆中
    Account acct;
    {
        name ="匿名客户";
    }
    public Customer(){
        acct=new Account();
    }

}

class Account{

}
