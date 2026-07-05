package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main configuration layout path execution.");

        // Execute Hands-on validation test tracks
        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
    }

    private static void testGetAllCountries() {
        LOGGER.info("--- Start testGetAllCountries ---");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Countries cataloged in data store: {}", countries);
        LOGGER.info("--- End testGetAllCountries ---");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("--- Start testFindCountryByCode ---");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Found Target Country Match: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Execution Exception Encountered: ", e);
        }
        LOGGER.info("--- End testFindCountryByCode ---");
    }

    private static void testAddCountry() {
        LOGGER.info("--- Start testAddCountry ---");
        try {
            Country newCountry = new Country("KH", "Cambodia");
            countryService.addCountry(newCountry);

            Country checked = countryService.findCountryByCode("KH");
            LOGGER.debug("Verified newly injected repository row entity: {}", checked);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Addition lifecycle verification failure: ", e);
        }
        LOGGER.info("--- End testAddCountry ---");
    }

    private static void testUpdateCountry() {
        LOGGER.info("--- Start testUpdateCountry ---");
        try {
            countryService.updateCountry("KH", "Kingdom of Cambodia");
            Country updatedCountry = countryService.findCountryByCode("KH");
            LOGGER.debug("Verified record mutation tracking: {}", updatedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Mutation tracking assertion exception state: ", e);
        }
        LOGGER.info("--- End testUpdateCountry ---");
    }

    private static void testDeleteCountry() {
        LOGGER.info("--- Start testDeleteCountry ---");
        countryService.deleteCountry("KH");
        try {
            countryService.findCountryByCode("KH");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Entity termination cycle completed successfully: {}", e.getMessage());
        }
        LOGGER.info("--- End testDeleteCountry ---");
    }
}