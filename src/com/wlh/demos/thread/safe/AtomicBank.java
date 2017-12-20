package com.wlh.demos.thread.safe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by linghui.wlh on 19/12/17.
 */
public class AtomicBank extends Bank {

    //使用AtomicInteger
    public AtomicInteger account = new AtomicInteger(10);

    //add by one
    public void deposite(){
        this.account.getAndIncrement();
    }

    //minus by one
    public void widthdraw(){
        this.account.getAndDecrement();
    }
}
