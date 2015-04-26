package com.aop;

import org.springframework.stereotype.Component;

/**
 * Created by jiazhong on 2015/4/23.
 */

@Component("performerImpl")
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
