package com.springindepth;

/**
 * Created by jiazhong on 2015/4/21.
 */
public class DoublerBean {
    protected int value = 0;

    /**
     * Gets value.
     */
    @Doubler
    public int getValue() {
        return value;
    }

    /**
     * Sets value.
     */
    public void setValue(int value) {
        this.value = value;
    }
}
