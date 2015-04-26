package com.aop.declareparent;

/**
 * Created by jiazhong on 2015/4/25.
 */
public class StudentAdditionalDetailsImpl implements StudentAdditionalDetails {
    private String city;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void showAdditionalDetails() {
        System.out.println(this.city);
        System.out.println(this.country);
    }
}
