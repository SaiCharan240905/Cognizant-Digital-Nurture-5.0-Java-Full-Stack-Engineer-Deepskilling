package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    void testExceptionThrown() {

        Exception exception =
                assertThrows(
                        RuntimeException.class,
                        () -> {
                            new ExceptionThrower()
                                    .throwException();
                        }
                );

        assertEquals(
                "Sample Exception",
                exception.getMessage()
        );
    }
}