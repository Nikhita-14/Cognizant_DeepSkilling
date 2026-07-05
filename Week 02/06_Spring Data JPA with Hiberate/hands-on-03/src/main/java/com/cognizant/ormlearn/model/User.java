package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryRepository countryRepository;
    private static StockRepository stockRepository;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryRepository = context.getBean(CountryRepository.class);
        stockRepository = context.getBean(StockRepository.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        LOGGER.info("Executing Complete Test Matrix Pipeline Framework...");

        // Hands-on 1 Execution Paths
        testCountryQueryMethods();

        // Hands-on 2 Execution Paths
        testStockQueryMethods();

        // Hands-on 4, 5, 6 Enterprise Relationship Verification Tracking
        testRelationshipMappingFlows();
    }

    private static void testCountryQueryMethods() {
        LOGGER.info("================ HANDS-ON 1: COUNTRY QUERIES ================");
        LOGGER.debug("Countries matching 'ou': {}", countryRepository.findByNameContaining("ou"));
        LOGGER.debug("Countries matching 'ou' Sorted Ascending: {}", countryRepository.findByNameContainingOrderByNameAsc("ou"));
        LOGGER.debug("Countries starting with 'Z': {}", countryRepository.findByNameStartingWith("Z"));
    }

    private static void testStockQueryMethods() {
        LOGGER.info("================ HANDS-ON 2: STOCK QUERIES ================");
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date start = df.parse("2019-09-01");
            Date end = df.parse("2019-09-30");

            LOGGER.debug("FB Stocks (Sept 2019): {}", stockRepository.findByCodeAndDateBetween("FB", start, end));
            LOGGER.debug("Google Stocks > 1250: {}", stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250.00));
            LOGGER.debug("Top 3 Highest Volume Transactions: {}", stockRepository.findTop3ByOrderByVolumeDesc());
            LOGGER.debug("Top 3 Lowest Netflix Closing Entries: {}", stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX"));
        } catch (Exception e) {
            LOGGER.error("Date formatting exception trace encountered: ", e);
        }
    }

    private static void testRelationshipMappingFlows() {
        LOGGER.info("================ RELATIONSHIP TRACKING PATHS ================");

        // Hands-on 4: Fetch Employee along with joined ManyToOne Department details
        Employee emp = employeeService.get(1);
        if (emp != null) {
            LOGGER.debug("Employee: {}", emp);
            LOGGER.debug("Associated Department [ManyToOne]: {}", emp.getDepartment());
            // Hands-on 6: Display Linked Skills [ManyToMany]
            LOGGER.debug("Associated Skill Sets [ManyToMany]: {}", emp.getSkillList());
        }

        // Hands-on 5: Fetch Department along with inverse OneToMany Employee lists
        Department dept = departmentService.get(2);
        if (dept != null) {
            LOGGER.debug("Department Data: {}", dept);
            LOGGER.debug("Linked Employee List Elements [OneToMany]: {}", dept.getEmployeeList());
        }

        // Hands-on 6: Add Skill to Employee Mapping Update Process
        LOGGER.info("--- Testing Add Skill To Employee Runtime Flow ---");
        Employee worker = employeeService.get(3); // Bob Johnson
        Skill techSkill = skillService.get(1);     // Java
        if (worker != null && techSkill != null) {
            worker.getSkillList().add(techSkill);
            employeeService.save(worker);
            LOGGER.debug("Successfully appended skill entity relation matrix row target references.");
        }
    }
}