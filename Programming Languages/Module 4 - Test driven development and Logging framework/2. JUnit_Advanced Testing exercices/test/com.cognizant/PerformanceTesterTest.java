package com.cognizant;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    @Test
    void testPerformance() {

        assertTimeout(
                Duration.ofSeconds(2),
                () -> {
                    new PerformanceTester()
                            .performTask();
                }
        );
    }
}