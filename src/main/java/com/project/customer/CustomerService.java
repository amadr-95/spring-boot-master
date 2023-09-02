package com.project.customer;

import com.project.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    public Customer getCustomer(Long customerId) {
        return customerDAO.findById(customerId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("customer with id %s does not exist".formatted(customerId))
                );
    }
}
