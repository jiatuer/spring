package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by jiazhong on 2015/4/23.
 */
public class Audience {


    public void takeseats() {
        System.out.println("The audience is taking their seats.");
    }

    public void turnOffCellPhones() {
        System.out.println("The audience is truning off their cellphones.");
    }

    public void applaud() {
        System.out.println("CLAP CLAP CLAP CLAP CLAP.");
    }

    public void demandRefund() {
        System.out.println("Boo! We want our money back!.");
    }


    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("The audience is taking their seats.");
            System.out.println("The audience is turning off their cellphones");
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("CLAP CLAP CLAP");
            System.out.println("The performance took "+(end - start)+" milliseconds.");
        } catch (Throwable e) {
            System.out.println("Boo! We want our money back!");
        }
    }

}
