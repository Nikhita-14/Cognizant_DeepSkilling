package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {
    // Static lists populated via Spring XML metadata configuration definitions
    private static ArrayList<Employee> EMPLOYEE_LIST = new ArrayList<>();
    private static ArrayList<Department> DEPARTMENT_LIST = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
        DEPARTMENT_LIST = context.getBean("departmentList", ArrayList.class);
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}