package com.aop.arg;

/**
 * Created by jiazhong on 2015/4/23.
 */
public class Magican implements MindReaer {
    private String thoughts;

    @Override
    public void interceptThoughts(String thought) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thought;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
