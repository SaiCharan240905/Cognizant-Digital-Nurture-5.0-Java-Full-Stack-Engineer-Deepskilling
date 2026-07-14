package com.cognizant.employee_management.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.employee_management.model.Employee;

@Repository
public class EmployeeDao {

    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        EMPLOYEE_LIST =
                (ArrayList<Employee>) context.getBean("employeeList");

    }
    public Employee updateEmployee(Employee employee) {

        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {

            if (EMPLOYEE_LIST.get(i).getId() == employee.getId()) {

                EMPLOYEE_LIST.set(i, employee);

                return employee;
            }
        }

        return null;
    }
    public boolean deleteEmployee(int id) {

        return EMPLOYEE_LIST.removeIf(emp -> emp.getId() == id);

    }
    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}