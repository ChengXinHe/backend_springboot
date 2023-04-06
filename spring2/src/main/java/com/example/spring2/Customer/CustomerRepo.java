package com.example.spring2.Customer;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo {
    List<Customer> getCustomers();
}
