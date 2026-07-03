package com.cognizant.spring_learn_2.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn_2.exception.CountryNotFoundException;
import com.cognizant.spring_learn_2.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.spring_learn_2.service.CountryService;

import com.cognizant.spring_learn_2.exception.CountryNotFoundException;
import jakarta.validation.Valid;

@RequestMapping("/countries")
@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

        @Autowired
        private CountryService countryService;
        @PostMapping
        public Country addCountry(@RequestBody Country country) {

                LOGGER.info("START");

                LOGGER.debug("Country : {}", country);

                LOGGER.info("END");

                return country;
        }
    @RequestMapping("/country")
    public Country getCountryIndia() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country =
                context.getBean("country", Country.class);

        LOGGER.info("END");

        return country;
    }
    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                context.getBean("countryList", List.class);

        LOGGER.debug("Countries : {}", countries);

        LOGGER.info("END");

        return countries;
    }
    @GetMapping("/countries/{code}")
        public Country getCountry(@PathVariable String code) 
        throws CountryNotFoundException {

        LOGGER.info("START");

        Country country = countryService.getCountry(code);

        LOGGER.debug("Country : {}", country);

        LOGGER.info("END");

        return country;
        }
}
