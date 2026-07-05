package com.example.ems.repository;

import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived Query Method (Exercise 3)
    List<Employee> findByNameContaining(String infix);

    // Custom Query using @Query Annotation (Exercise 5)
    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findEmployeesByDeptName(@Param("deptName") String deptName);

    // Execute Named Query definition mapped on Entity (Exercise 5)
    List<Employee> fetchByEmailNamed(@Param("email") String email);

    // Pagination and Sorting Query target (Exercise 6)
    Page<Employee> findAll(Pageable pageable);

    // Dynamic Projection Fetch Execution (Exercise 8)
    List<EmployeeProjection> findByDepartmentId(Long departmentId);
}