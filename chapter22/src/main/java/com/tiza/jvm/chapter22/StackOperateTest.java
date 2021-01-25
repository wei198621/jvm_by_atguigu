package com.tiza.jvm.chapter22;

/**
 * @author leowei
 * @date 2021/1/25  - 23:06
 */
public class StackOperateTest {
    public static void main(String[] args) {

    }

    private long index;

    /**
     0 new #2 <java/lang/Object>
     3 dup
     4 invokespecial #1 <java/lang/Object.<init>>
     7 astore_1
     8 aload_1
     9 invokevirtual #3 <java/lang/Object.toString>
     12 astore_2
     13 return
     */
    public void print(){
        Object obj = new Object();
        String info = obj.toString();
    }

    /**
     0 aload_0
     1 invokevirtual #4 <com/tiza/jvm/chapter22/StackOperateTest.bar>
     4 pop2
     5 return

     */
    public void foo(){
        bar();
    }

    /**
     0 lconst_0
     1 lreturn
     * @return
     */
    public long bar(){
        return 0;
    }

    /**
     0 aload_0
     1 dup
     2 getfield #5 <com/tiza/jvm/chapter22/StackOperateTest.index>
     5 dup2_x1
     6 lconst_1
     7 ladd
     8 putfield #5 <com/tiza/jvm/chapter22/StackOperateTest.index>
     11 lreturn

     * @return
     */
    public long nextIndex(){
        return index++;
    }
}
