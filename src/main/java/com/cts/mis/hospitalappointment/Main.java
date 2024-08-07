package com.cts.mis.hospitalappointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Hospital Appointment application.
 * This class bootstraps the Spring Boot application.
 */
@SpringBootApplication
public class Main {
    /**
     * The main method which serves as the entry point for the Spring Boot application.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}