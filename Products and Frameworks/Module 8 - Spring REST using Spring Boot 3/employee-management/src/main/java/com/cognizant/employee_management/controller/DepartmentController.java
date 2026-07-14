package com.cognizant.employee_management.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employee_management.model.Department;
import com.cognizant.employee_management.service.DepartmentService;

@RestController
public class DepartmentController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public ArrayList<Department> getAllDepartments() {

        LOGGER.info("START");

        ArrayList<Department> departments =
                departmentService.getAllDepartments();

        LOGGER.debug("Departments : {}", departments);

        LOGGER.info("END");

        return departments;
    }

}