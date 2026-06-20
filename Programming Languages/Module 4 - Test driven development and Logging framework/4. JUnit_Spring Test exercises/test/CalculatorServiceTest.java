package com.cognizant;

import com.cognizant.service.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService =
            new CalculatorService();

    @Test
    void testAdd() {

        assertEquals(
                15,
                calculatorService.add(10, 5)
        );
    }
}