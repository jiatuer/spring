package com.aop.declareparent;

import org.springframework.stereotype.Component;

/**
 * Created by jiazhong on 2015/4/25.
 */

@Component("contestantDelegate")
public class GraciousContestant implements Contestant {
    @Override
    public void receiveAward() {
        System.out.println("recive award");
    }
}
