package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries") // Applied at base class level to adhere to standards
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("START - Recieved body request payload");
        LOGGER.info("Country Code: {}, Country Name: {}", country.getCode(), country.getName());
        LOGGER.info("END - Safe validation check complete");
        return country;
    }
}