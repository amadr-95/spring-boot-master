package com.project.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(@Qualifier("real") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}
