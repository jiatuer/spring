package com;

import com.aop.Performer;
import com.aop.declareparent.Student;
import com.aop.declareparent.StudentAdditionalDetails;
import com.jdbc.Employee;
import com.jdbc.EmployeeDao;
import com.jdbc.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.UUID;

/**
 * Created by jiazhong on 2015/4/21.
 */
public class MainApp {

    final static Logger logger = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

           EmployeeService service = (EmployeeService)context.getBean("EmployeeService");
           Employee pay = service.findEmployeeByName("Jason");
           Employee receive = service.findEmployeeByName("jack");

            receive.setAccount(111111111);
//            service.updateEmployeeAccount(pay);
            service.trasferAccount(pay,receive,11);
//           dao.addEmployee(e1);
//            dao.updateEmployeeAccount(e1);
//        Performer performer = (Performer) context.getBean("performerImpl");
//        performer.perform();

//        Thinker volunteer = (Thinker) context.getBean("volunteerThinker");
//        volunteer.thinkOfSomething("I want to bu a castle.");
//        Magican magican = (Magican)context.getBean("magican");
//        System.out.println("I think know what you thinking :"+magican.getThoughts());

//        StudentAdditionalDetails studentAdditionalDetails = (StudentAdditionalDetails) context.getBean("studentAdditionalDetails");
//        ((Student) studentAdditionalDetails).showDetails();
//        studentAdditionalDetails.showAdditionalDetails();

    }

}
