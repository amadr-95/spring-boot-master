package com.project.customer;

import java.util.Collections;
import java.util.List;

public class CustomerRepository implements CustomerDAO {
    @Override
    public List<Customer> getCustomers() {
        //TODO connect to real db
        return Collections.singletonList(
                new Customer(0L, "TODO. Implement real db", "todo", "email@gmail.com")
        );
    }
}
