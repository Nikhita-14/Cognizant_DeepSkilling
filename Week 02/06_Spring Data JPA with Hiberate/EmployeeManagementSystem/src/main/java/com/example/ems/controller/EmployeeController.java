package com.example.ems.controller;

import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeProjection;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeRepository.save(emp);
    }

    // Paginated and Sorted Search Endpoint (Exercise 6)
    @GetMapping("/search")
    public Page<Employee> getEmployeesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        return employeeRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy).ascending()));
    }

    // Custom @Query Endpoint Verification (Exercise 5)
    @GetMapping("/dept/{deptName}")
    public List<Employee> getByDeptName(@PathVariable String deptName) {
        return employeeRepository.findEmployeesByDeptName(deptName);
    }

    // Projection Specific Retrieval Path (Exercise 8)
    @GetMapping("/projection/dept/{deptId}")
    public List<EmployeeProjection> getProjectedStaff(@PathVariable Long deptId) {
        return employeeRepository.findByDepartmentId(deptId);
    }
}