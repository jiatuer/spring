package com.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiazhong on 2015/4/26.
 */

@Component("EmployeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeService {

    private TransactionTemplate transactionTemplate;

    @Autowired
    @Qualifier("EmployeeDao")
    private EmployeeDao employeeDao;

    @Autowired
    @Qualifier("transactionTemplate")
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }


    public Employee findEmployeeByName(String name) {
        return employeeDao.findEmployeeByName(name);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    public List findEmployee() {
        return employeeDao.findEmployee();
    }

    public void addEmploee(final Employee employee) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
                                        @Override
                                        public Object doInTransaction(TransactionStatus transactionStatus) {
                                            try {
                                                employeeDao.addEmployee(employee);
                                            } catch (RuntimeException e) {
                                                transactionStatus.setRollbackOnly();
                                                throw e;
                                            }
                                            return null;
                                        }
                                    }
        );

    }


    public void updateEmployeeAccount(Employee employee) {
        employeeDao.updateEmployeeAccount(employee);
    }

    public void trasferAccount(final Employee pay, final Employee receive, final int account) {

        transactionTemplate.execute(new TransactionCallback<Object>() {
                                        @Override
                                        public Object doInTransaction(TransactionStatus transactionStatus) {
                                            try {
                                                pay.setAccount(pay.getAccount() - account);
                                                receive.setAccount(receive.getAccount() + account);
                                                employeeDao.updateEmployeeAccount(pay);
                                                employeeDao.updateEmployeeAccount(receive);
                                            } catch (RuntimeException e) {
                                                transactionStatus.setRollbackOnly();
                                                throw e;
                                            }
                                            return null;
                                        }
                                    }
        );

    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void trasferAccountAnno(final Employee pay, final Employee receive, final int account) {

        pay.setAccount(pay.getAccount() - account);
        receive.setAccount(receive.getAccount() + account);
        employeeDao.updateEmployeeAccount(pay);
        employeeDao.updateEmployeeAccount(receive);

    }


}
