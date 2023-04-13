package com.example.spring2.Customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer lichu  = new Customer
                (1L,"lichu", "email1@gamil.com", "password123");
        Customer Xinhe = new Customer
                (2L,"Xinhe", "email2@gamil.com", "123password");

        customerRepository.saveAll(Arrays.asList(lichu, Xinhe));

        List<Customer> customers = underTest.getCustomers();

        assertEquals(2, customers.size());

    }

    @Test
    void getCustomer() {
        Customer lichu  = new Customer
                (1L,"lichu", "email1@gamil.com", "password123");

        customerRepository.save(lichu);

        Customer customer = underTest.getCustomer(1L);

        assertEquals(1L, customer.getId());
        assertEquals("lichu", customer.getName());
        assertEquals("email1@gamil.com", customer.getEmail());
        assertEquals("password123", customer.getPassword());

    }
}