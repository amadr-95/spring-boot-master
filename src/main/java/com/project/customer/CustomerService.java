package com.project.customer;

import com.project.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        LOGGER.info("calling getCustomers");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(
                        () -> {
                            ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException(
                                    "customer with id %s does not exist".formatted(customerId));
                            LOGGER.error("error in getting customer {}", customerId, resourceNotFoundException);
                            return resourceNotFoundException;
                        }
                );
    }
}
