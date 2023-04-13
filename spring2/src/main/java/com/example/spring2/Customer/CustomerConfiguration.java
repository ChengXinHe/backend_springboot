package com.example.spring2.Customer;

import com.example.spring2.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.swing.plaf.synth.SynthOptionPaneUI;

@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;


    @Value("${info.app.name}")
    private String aName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp) {
        return args -> {
            System.out.println("CommandLineRunner");
            System.out.println(aName);
            System.out.println(environment.getProperty("info.app.version"));
            System.out.println(infoApp);
        };
    }
    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}
