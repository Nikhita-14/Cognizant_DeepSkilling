package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CountryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @SuppressWarnings("unchecked")
    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START - Locating country code: {}", code);

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countriesList = context.getBean("countryList", ArrayList.class);

        // Functional streams filtering out data using case-insensitive matches (Hands-on 5)
        Country match = countriesList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(CountryNotFoundException::new);

        LOGGER.info("END - Successfully matched country data");
        return match;
    }
}