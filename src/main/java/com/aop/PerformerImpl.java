package com.aop;

/**
 * Created by jiazhong on 2015/4/23.
 */
public class PerformerImpl implements Performer {

    @Override
    public void perform() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("perform");
    }
}
