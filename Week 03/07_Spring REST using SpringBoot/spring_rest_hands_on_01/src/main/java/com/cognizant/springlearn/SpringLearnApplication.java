package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);

        LOGGER.info("Starting Spring Core Verification Routines...");

        // Execute Hands-on Exercises sequentially
        displayDate();
        displayCountry();
        displayCountries();
    }

    // Hands-on 2 & 3: Date Parsing Context Test
    public static void displayDate() {
        LOGGER.info("START");
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

            Date parsedDate = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", parsedDate);
        } catch (Exception e) {
            LOGGER.error("Error executing displayDate logic", e);
        }
        LOGGER.info("END");
    }

    // Hands-on 4 & 5: Single Country Extraction & Scope Analysis
    public static void displayCountry() {
        LOGGER.info("START - Country Retrieval Analysis");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // Fetch primary instance (Hands-on 4)
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());

        // Fetch secondary instance from same context container (Hands-on 5 Scope Demo)
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Secondary Reference Pulled: {}", anotherCountry.toString());

        LOGGER.info("END - Country Retrieval Analysis");
    }

    // Hands-on 6: Array Aggregation Structural Parsing
    @SuppressWarnings("unchecked")
    public static void displayCountries() {
        LOGGER.info("START - Bulk Countries Collection Retrieval");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countriesList = context.getBean("countryList", ArrayList.class);

        LOGGER.debug("Retrieved Country List size: {}", countriesList.size());
        LOGGER.debug("Countries Array Details: {}", countriesList);

        LOGGER.info("END - Bulk Countries Collection Retrieval");
    }
}