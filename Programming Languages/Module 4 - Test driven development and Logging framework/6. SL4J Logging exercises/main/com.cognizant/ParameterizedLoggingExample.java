package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    ParameterizedLoggingExample.class
            );

    public static void main(String[] args) {

        String userName = "Sai";
        int userId = 101;

        logger.info(
                "User {} with ID {} logged in successfully",
                userName,
                userId
        );

        logger.debug(
                "Processing request for user {}",
                userName
        );
    }
}