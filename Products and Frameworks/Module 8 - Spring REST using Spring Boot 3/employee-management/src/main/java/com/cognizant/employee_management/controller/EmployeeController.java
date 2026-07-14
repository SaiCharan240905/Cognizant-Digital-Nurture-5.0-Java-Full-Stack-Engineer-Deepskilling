package com.cognizant.employee_management.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employee_management.model.Employee;
import com.cognizant.employee_management.service.EmployeeService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmployeeController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {

        LOGGER.info("START");

        ArrayList<Employee> employees =
                employeeService.getAllEmployees();

        LOGGER.debug("Employees : {}", employees);

        LOGGER.info("END");

        return employees;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        LOGGER.info("START");

        Employee updatedEmployee =
                employeeService.updateEmployee(employee);

        LOGGER.debug("Updated Employee : {}", updatedEmployee);

        LOGGER.info("END");

        return updatedEmployee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        LOGGER.info("START");

        boolean deleted = employeeService.deleteEmployee(id);

        LOGGER.info("END");

        if (deleted) {
            return "Employee deleted successfully";
        }

        return "Employee not found";
    }
}