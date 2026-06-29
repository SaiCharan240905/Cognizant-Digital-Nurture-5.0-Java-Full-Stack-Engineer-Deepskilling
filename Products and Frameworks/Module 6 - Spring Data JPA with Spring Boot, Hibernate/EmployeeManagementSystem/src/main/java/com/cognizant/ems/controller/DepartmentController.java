package com.cognizant.ems.controller;
// Search Department by Name

@GetMapping("/search/{name}")
public List<Department> findDepartment(@PathVariable String name) {

    return departmentRepository.findByName(name);
}


// Sort Departments

@GetMapping("/sort")
public List<Department> getDepartmentsSorted() {

    return departmentRepository.getDepartmentsSorted();
}