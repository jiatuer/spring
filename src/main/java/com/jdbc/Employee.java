package com.jdbc;

/**
 * Created by jiazhong on 2015/4/26.
 */
public class Employee {

    private int region;

    private String name;

    private  int account;

    public Employee(){}

    public Employee(int region,String name,int account){
        this.region = region;
        this.name = name;
        this.account = account;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
