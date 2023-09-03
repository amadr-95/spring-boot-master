package com.project.customer;

import com.project.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerDAO customerDAO;

    public List<Customer> getCustomers() {
        log.info("calling getCustomers");
        return customerDAO.getCustomers();
    }

    public Customer getCustomer(Long customerId) {
        return customerDAO.findById(customerId)
                .orElseThrow(
                        () -> {
                            ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException(
                                    "customer with id %s does not exist".formatted(customerId));
                            log.error("error in getting customer {}", customerId, resourceNotFoundException);
                            return resourceNotFoundException;
                        }
                );
    }
}
