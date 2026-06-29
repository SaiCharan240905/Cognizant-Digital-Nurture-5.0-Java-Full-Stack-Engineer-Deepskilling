package com.cognizant.ems.controller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.cognizant.ems.projection.EmployeeDTO;
import com.cognizant.ems.projection.EmployeeProjection;
// Find Employee by Name

@GetMapping("/search/name/{name}")
public List<Employee> findEmployeeByName(@PathVariable String name) {

    return employeeRepository.findByName(name);
}


// Find Employee by Email

@GetMapping("/search/email/{email}")
public Optional<Employee> findEmployeeByEmail(@PathVariable String email) {

    return employeeRepository.findByEmail(email);
}


// Find Employees by Department

@GetMapping("/search/department/{department}")
public List<Employee> findByDepartment(@PathVariable String department) {

    return employeeRepository.findByDepartmentName(department);
}


// Search Email using JPQL

@GetMapping("/search/emailContains/{keyword}")
public List<Employee> searchByEmail(@PathVariable String keyword) {

    return employeeRepository.searchByEmail(keyword);
}


// Sort Employees

@GetMapping("/sort")
public List<Employee> getEmployeesSorted() {

    return employeeRepository.getEmployeesSortedByName();
}

// Pagination

@GetMapping("/page")
public Page<Employee> getEmployeesByPage(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {

    Pageable pageable = PageRequest.of(page, size);

    return employeeRepository.findAll(pageable);
}


// Sorting

@GetMapping("/sort/{field}")
public List<Employee> sortEmployees(@PathVariable String field) {

    return employeeRepository.findAll(
            Sort.by(Sort.Direction.ASC, field)
    );
}


// Pagination + Sorting

@GetMapping("/pageSort")
public Page<Employee> pageAndSort(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "name") String field) {

    Pageable pageable = PageRequest.of(
            page,
            size,
            Sort.by(field).ascending()
    );

    return employeeRepository.findAll(pageable);
}

@GetMapping("/projection")
public List<EmployeeProjection> getEmployeeProjection() {

    return employeeRepository.findAllProjectedBy();

}

@GetMapping("/dto")
public List<EmployeeDTO> getEmployeeDTO() {

    return employeeRepository.getEmployeeDTO();

}

@PostMapping("/batch")
public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {

    for (Employee employee : employees) {

        if (employee.getDepartment() != null &&
                employee.getDepartment().getId() != null) {

            Department department = departmentRepository
                    .findById(employee.getDepartment().getId())
                    .orElseThrow();

            employee.setDepartment(department);
        }

    }

    return employeeRepository.saveAll(employees);
}