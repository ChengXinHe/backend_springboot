package com.example.spring2.Customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.plaf.synth.SynthOptionPaneUI;

@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("CommandLineRunner");
        };
    }
    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return useFakeCustomerRepo ?
                new CustomerFakeRepository():
                new CustomerRepository();
    }
}
