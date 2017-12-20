package com.wlh.demos.thread.unsafe;

/**
 * Created by linghui.wlh on 19/12/17.
 */
public class UnsafeBank2 {

    int account = 10;

    public static void main(String [] args){
        UnsafeBank2 ub2 = new UnsafeBank2();

        //两个线程持有同一个对象ub2
        Thread t1 = new ThreadA(ub2);
        Thread t2 = new ThreadB(ub2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ub2.account);
    }

    public void deposite(){
        this.account ++;
    }

    public void widthdraw(){
        this.account --;
    }
}

//存钱线程
class ThreadA extends Thread{

    private UnsafeBank2 ub;
    //构造函数,传入对象引用
    public ThreadA(UnsafeBank2 ub){
        this.ub = ub;
    }

    @Override
    public void run(){
        for(int i = 0; i < 100000; i ++){
            ub.deposite();
        }
    }
}

//取钱线程
class ThreadB extends Thread{

    private UnsafeBank2 ub;
    //构造函数,传入对象引用
    public ThreadB(UnsafeBank2 ub){
        this.ub = ub;
    }

    @Override
    public void run(){
        for(int i = 0; i < 100000; i ++){
            ub.widthdraw();
        }
    }
}
