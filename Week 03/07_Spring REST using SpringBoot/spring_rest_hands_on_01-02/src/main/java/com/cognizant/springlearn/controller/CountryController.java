package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    // Explicit @RequestMapping definition returning a single parsed bean mapping layer
    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - Country Target Fetch");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country india = context.getBean("country", Country.class);
        LOGGER.info("END - Country Target Fetch");
        return india;
    }

    @GetMapping("/countries")
    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {
        LOGGER.info("START - Retrieval of bulk country data layers");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> list = context.getBean("countryList", ArrayList.class);
        LOGGER.info("END - Retrieval of bulk country data layers");
        return list;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
        LOGGER.info("START - Pathvariable dynamic country resolution for code: {}", code);
        Country target = countryService.getCountry(code);
        LOGGER.info("END - Pathvariable dynamic country resolution");
        return target;
    }
}