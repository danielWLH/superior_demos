package com.wlh.demos.thread.safe;

/**
 * Created by linghui.wlh on 19/12/17.
 */
public class BankTester {

    public static void main(String [] args) throws InterruptedException {
        Bank bank = new LockBank();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000; i ++){
                    bank.deposite();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000; i ++){
                    bank.widthdraw();
                }
            }
        });

        t1.start();
        t2.start();

        //查看活动线程数
        System.out.println(Thread.activeCount());

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //查看活动线程数
        System.out.println(Thread.activeCount());

        System.out.println(bank.account);
    }
}
