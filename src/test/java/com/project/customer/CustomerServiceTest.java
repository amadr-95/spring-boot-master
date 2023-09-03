package com.project.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class CustomerServiceTest {

    private final CustomerRepository customerRepository;
    private CustomerService customerService;

    @Autowired
    CustomerServiceTest(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        List<Customer> customers = List.of(
                new Customer(1L, "customer1", "pass", "customer1@gmail.com"),
                new Customer(2L, "customer2", "pass", "customer2@gmail.com")
        );

        customerRepository.saveAll(customers);

        Assertions.assertEquals(2, customerService.getCustomers().size());
        Assertions.assertEquals(customers, customerService.getCustomers());

    }

    @Test
    void getCustomer() {
        Customer customer1 = new Customer(1L, "customer1", "pass", "customer1@gmail.com");

        customerRepository.save(customer1);

        Assertions.assertEquals(customer1, customerService.getCustomer(customer1.getId()));
    }
}