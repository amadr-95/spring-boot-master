package com.project.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    //this value is given by program arguments (false by default)
    /*@Value("${app.useFakeCustomerRepo:false}")
    private boolean useFakeCustomerRepo;*/

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Command line runner hooray");
        };
    }

   /* @Bean
    CustomerDAO customerDAO() {
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return useFakeCustomerRepo ? new CustomerFakeRepository() : new CustomerRepository();
    }*/
}
