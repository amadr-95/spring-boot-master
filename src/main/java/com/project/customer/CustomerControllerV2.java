package com.project.customer;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v2/customers")
@RestController
public class CustomerControllerV2 {

    private final CustomerService customerService;

    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void createCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long custometId) {
        System.out.println("DELETE customer with id " + custometId);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST...");
    }

}
