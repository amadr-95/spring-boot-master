package com.project.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> getCustomers();

    Optional<Customer> findById(Long id);
}
