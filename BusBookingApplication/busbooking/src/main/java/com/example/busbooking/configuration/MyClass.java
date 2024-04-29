package com.example.busbooking.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.java.Log;

public class MyClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyClass.class);

    public void myMethod() {
        for(int i = 0; i < 1000; i ++){
            LOGGER.debug("This is a debug message");
            LOGGER.info("This is an info message");
            LOGGER.warn("This is a warning message");
            LOGGER.error("This is an error message");
        }
    }
}
