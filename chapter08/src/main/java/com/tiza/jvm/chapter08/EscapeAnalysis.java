package com.tiza.jvm.chapter08;

/**
 * @author leowei
 * @date 2021/1/10  - 11:16
 *
 * 判断逃逸分析的发生： new 的对象实体，是否在方法外被调用
 *
 */
public class EscapeAnalysis {
    public EscapeAnalysis obj;

    /*
    此方法返回的Obj实体，会在方法外部被调用
     */
    public EscapeAnalysis getInstance(){
        return obj ==null ? new EscapeAnalysis() :obj;
    }

    /*
    为成员变量赋值，发生逃逸
     */
    public void setObj(){
        this.obj =new EscapeAnalysis();
    }

    /*
    对象esc 的作用域尽在当前方法，没有发生逃逸
     */
    public void useEscapeAnalysis(){
        EscapeAnalysis esc = new EscapeAnalysis();
    }

    /*
    引用成员变量发生逃逸
     */
    public void useEscapeAnalysis2(){
        EscapeAnalysis esc2 = getInstance();
    }
}
