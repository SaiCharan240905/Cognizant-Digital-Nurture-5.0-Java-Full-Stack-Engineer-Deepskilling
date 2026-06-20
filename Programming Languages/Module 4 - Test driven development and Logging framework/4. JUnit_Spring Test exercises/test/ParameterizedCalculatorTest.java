package com.cognizant;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ParameterizedCalculatorTest {

    CalculatorService service =
            new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "10,20,30",
            "5,5,10"
    })
    void testAdd(
            int a,
            int b,
            int expected
    ) {

        assertEquals(
                expected,
                service.add(a, b)
        );
    }
}