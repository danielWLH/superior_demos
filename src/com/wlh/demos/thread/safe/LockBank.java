package com.wlh.demos.thread.safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by linghui.wlh on 19/12/17.
 */
public class LockBank extends Bank {
    Lock lock = new ReentrantLock();

    //add by one
    public void deposite(){

        try {
            lock.lock();
            this.account ++;
        } finally{
            lock.unlock();
        }
    }

    //minus by one
    public void widthdraw(){

        try {
            lock.lock();
            this.account --;
        } finally{
            lock.unlock();
        }
    }
}
