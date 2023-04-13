package com.example.spring2.Customer;

import com.example.spring2.exception.ApiRequestException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v2/customers")
@AllArgsConstructor
public class CustomerController2 {
    private final CustomerService customerService;
    // 因为有@AllArgsConstructor，所以可以删掉。
//    @Autowired
//    CustomerController2(CustomerService customerService) {
//        this.customerService = customerService;
//    }

    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id)  {
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id)  {
        throw new ApiRequestException(
                "ApiRequestException for customer " + id
        );
    }

    @PostMapping
    void createCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("Post ...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("update ...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("Delete with id");
        System.out.println(id);
    }
}
