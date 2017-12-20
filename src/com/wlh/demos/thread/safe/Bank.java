package com.wlh.demos.thread.safe;

/**
 * Created by linghui.wlh on 19/12/17.
 * 所有bank类的父类
 */
public class Bank {

    public int account = 10;

    //add by one
    public void deposite(){
        this.account ++;
    }

    //minus by one
    public void widthdraw(){
        this.account --;
    }

}
