package com.example.spring2.Customer;

import com.example.spring2.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {
    // 因为有@Slf4j，所以可以删掉。
//    private final static Logger LOGGER =
//            LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
// 因为有@AllArgsConstructor，所以可以删掉。
//    @Autowired
//    public CustomerService(
//            CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id)  {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException (
                                    "customer with id " + id + " not found");
                            log.error("error in getting customer {}", id, notFoundException);
                            return notFoundException;
                        });
    }
}
