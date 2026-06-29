package com.cognizant.ems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.ems.entity.Employee;
import com.cognizant.ems.projection.EmployeeDTO;
import com.cognizant.ems.projection.EmployeeProjection;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived Query Methods

    List<Employee> findByName(String name);

    Optional<Employee> findByEmail(String email);

    List<Employee> findByDepartmentName(String departmentName);

    // JPQL Query

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %?1%")
    List<Employee> searchByEmail(String keyword);

    @Query("SELECT e FROM Employee e ORDER BY e.name ASC")
    List<Employee> getEmployeesSortedByName();

}

// ---------------- Projection ----------------

List<EmployeeProjection> findAllProjectedBy();


// ---------------- DTO Projection ----------------

@Query("""
       SELECT new com.cognizant.ems.projection.EmployeeDTO(
       e.name,
       e.email)
       FROM Employee e
       """)
List<EmployeeDTO> getEmployeeDTO();