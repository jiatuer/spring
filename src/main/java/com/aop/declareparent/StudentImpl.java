package com.aop.declareparent;

/**
 * Created by jiazhong on 2015/4/25.
 */
public class StudentImpl implements Student {

    private int studentNo;

    private String studentName;


    public int getStudentNo() {
        return studentNo;
    }


    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }


    public String getStudentName() {
        return studentName;
    }


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public void showDetails() {
        System.out.println(this.studentNo);
        System.out.println(this.studentName);
    }
}
