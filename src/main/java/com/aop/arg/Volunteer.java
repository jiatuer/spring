package com.aop.arg;

/**
 * Created by jiazhong on 2015/4/23.
 */
public class Volunteer implements Thinker {
    private String thoughts;

    @Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts(){
        return thoughts;
    }
}
