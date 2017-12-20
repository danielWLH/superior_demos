package com.wlh.demos.thread.safe;

/**
 * Created by linghui.wlh on 19/12/17.
 */
public class SynchronizedBank extends Bank{

    //thread safe add by one
    public synchronized void deposite(){
        this.account ++;
    }

    //thread safe minus by one
    public synchronized void widthdraw(){
        this.account --;
    }
}
