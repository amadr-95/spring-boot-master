package com.project.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class CustomerFakeRepository implements CustomerDAO {
    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1L, "Amador", "password123", "email@gmail.com"),
                new Customer(2L, "Sandra", "123password", "email@gmail.com")
        );
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return getCustomers().stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }
}
