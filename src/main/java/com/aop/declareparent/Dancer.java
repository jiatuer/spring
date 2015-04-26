package com.aop.declareparent;

/**
 * Created by jiazhong on 2015/4/25.
 */
public class Dancer implements Performer {
    @Override
    public void perform() {
        System.out.println("dancing...");
    }
}
