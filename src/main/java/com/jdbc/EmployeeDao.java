package com.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiazhong on 2015/4/25.
 */

@Component("EmployeeDao")
public class EmployeeDao {

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
}
