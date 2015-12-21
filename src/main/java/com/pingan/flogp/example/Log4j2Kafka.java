package com.pingan.flogp.example;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Log4j2Kafka {
    private static final Logger LOGGER = Logger.getLogger(Log4j2Kafka.class);
    public static void main(String[] args) throws InterruptedException {
    	//PropertyConfigurator.configure("./src/main/resources/log4j.properties");
        LOGGER.info("info start================");
        LOGGER.debug("debug start================");
        for (int i = 0; i < 5; i++) {
            LOGGER.info("Info: [" + i + "]");
            LOGGER.debug("Debug: [" + i + "]");
        }
        LOGGER.info("end================");
        LOGGER.debug("end================");
 
    }
}