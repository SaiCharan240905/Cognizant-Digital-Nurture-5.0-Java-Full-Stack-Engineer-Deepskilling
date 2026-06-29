package com.cognizant.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived Query Method

    List<Department> findByName(String name);

    // JPQL Query

    @Query("SELECT d FROM Department d ORDER BY d.name")
    List<Department> getDepartmentsSorted();

}