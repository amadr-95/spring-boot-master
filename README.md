# Switching between implementations

We decide what type of repository implementation we want to use in the service class through the
`CustomerConfig` class:
```
 @Value("${app.useFakeCustomerRepo:false}")
    private boolean useFakeCustomerRepo;

    @Bean
    CustomerDAO customerDAO() {
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return useFakeCustomerRepo ? new CustomerFakeRepository() : new CustomerRepository();
    }
```

The value `app.useFakeCustomerRepo` is given by program arguments (false by default).
By doing so, we also have to delete any annotation like @Repository in repository classes
because the bean is now managed by us and not by spring (we create an instance of `CustomerFakeRepository()`
or `CustomerRepository()` depending on the value)