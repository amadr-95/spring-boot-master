package com.project.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier(value = "fake")
public class CustomerFakeRepository implements CustomerDAO {
    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1L, "Amador"),
                new Customer(2L, "Sandra")
        );
    }
}
