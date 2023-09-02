package com.project.customer;

import java.util.List;

public class CustomerFakeRepository implements CustomerDAO {
    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1L, "Amador", "password123", "email@gmail.com"),
                new Customer(2L, "Sandra", "123password", "email@gmail.com")
        );
    }
}
