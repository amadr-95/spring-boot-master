package com.project.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Qualifier(value = "real")
public class CustomerRepository implements CustomerDAO {
    @Override
    public List<Customer> getCustomers() {
        //TODO connect to real db
        return Collections.emptyList();
    }
}
