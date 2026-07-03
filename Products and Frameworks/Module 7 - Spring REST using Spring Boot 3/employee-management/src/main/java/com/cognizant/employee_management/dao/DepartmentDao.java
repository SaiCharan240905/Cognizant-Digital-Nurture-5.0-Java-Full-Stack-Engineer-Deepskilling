package com.cognizant.employee_management.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.employee_management.model.Department;

@Repository
public class DepartmentDao {

    private static ArrayList<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        DEPARTMENT_LIST =
                (ArrayList<Department>) context.getBean("departmentList");

    }

    public ArrayList<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }

}