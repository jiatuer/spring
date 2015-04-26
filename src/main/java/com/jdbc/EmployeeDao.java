package com.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiazhong on 2015/4/25.
 */

@Component("EmployeeDao")
public class EmployeeDao {

    private  final static String FIND_EMPLOYEE_BY_NAME = "select region,name,account from employee where name = ?";

    private final static String INSERT_EMPLOYEE_SQL = "insert into employee(region,name) values(?,?)";

    private final static String UPDATE_EMPLOYEE_ACCOUNT = " update employee set account = ? where name = ?";

    private SimpleJdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("jdbcTemplate")
    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List findEmployee() {
        List employees = new ArrayList();

        String QUERY_ALL_EMPLOYEE = "select * from employee";

        employees = jdbcTemplate.queryForList(QUERY_ALL_EMPLOYEE);
        return employees;
    }

    public Employee findEmployeeByName(String name){
        Employee e = jdbcTemplate.queryForObject(FIND_EMPLOYEE_BY_NAME, ParameterizedBeanPropertyRowMapper.newInstance(Employee.class),name);
        return e;
    }

    public void addEmployee(Employee employee) {
        Object[] params = new Object[]{employee.getRegion(), employee.getName()};
        jdbcTemplate.update(INSERT_EMPLOYEE_SQL, params);
    }

    public void updateEmployeeAccount(Employee employee){
        Object[] params = new Object[]{employee.getAccount(), employee.getName()};
        jdbcTemplate.update(UPDATE_EMPLOYEE_ACCOUNT,params);
    }


}
