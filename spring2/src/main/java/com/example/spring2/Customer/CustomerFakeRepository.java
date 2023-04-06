package com.example.spring2.Customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L,"lichu", "email1@gamil.com", "password123"),
                new Customer(2L,"Xinhe", "email2@gamil.com", "123password")
        );
    }
}
