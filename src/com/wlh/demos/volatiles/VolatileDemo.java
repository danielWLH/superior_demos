package com.wlh.demos.volatiles;

/**
 * Created by linghui.wlh on 22/12/17.
 */
public class VolatileDemo {

    public Boolean switch1 = false;
    public volatile Boolean switch2 = false;

    public static void main(String [] args){
        VolatileDemo vd = new VolatileDemo();
        vd.test();
    }

    public void test(){
        //启动十个线程来打印开关的值
        for(int i = 0; i < 10; i ++){
            Thread t;
            if(i == 5){
                //第五个线程是特殊线程,会修改switch的值
                t = new Thread(new Runner(switch1, switch2, 1));
            }else{
                t = new Thread(new Runner(switch1, switch2, 2));
            }
            t.start();
        }
    }
}

class Runner implements Runnable{

    public Boolean switch1;
    public Boolean switch2;
    public int tag;

    public Runner(Boolean switch1, Boolean switch2, int tag){
        this.switch1 = switch1;
        this.switch2 = switch2;
        this.tag = tag;
    }

    @Override
    public void run() {
        for(int i = 0; i < 50; i ++){
            System.out.println("Thread: " + Thread.currentThread().getName() + " value: " + switch1 + ", value2: " + switch2);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(tag == 1 && i == 20){
                switch1 = true;
                switch2 = true;
                System.out.println("------------------------");
            }
        }
    }
}
