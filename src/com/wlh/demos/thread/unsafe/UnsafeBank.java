package com.wlh.demos.thread.unsafe;

/**
 * Created by linghui.wlh on 19/12/17.
 */
public class UnsafeBank{

    int account = 10;

    public static void main(String [] args){
        UnsafeBank ub = new UnsafeBank();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000; i ++){
                    ub.deposite();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000; i ++){
                    ub.widthdraw();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ub.account);
    }

    public void deposite(){
        this.account ++;
    }

    public void widthdraw(){
        this.account --;
    }
}
