package com.project.customer;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fake")
public class CustomerFakeRepository implements CustomerDAO {
    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1L, "Amador", "password123"),
                new Customer(2L, "Sandra", "123password")
        );
    }
}
