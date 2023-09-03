# Proterties and Profiles

In config class we can access to application properties by using @Value annotation like that:
```
@Configuration
public class CustomerConfig {

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.version}")
    private String appVersion;

}
```

Another way to get access these properties is by creating and instance of Enviroment class:

```
@Configuration
public class CustomerConfig {
    private Environment environment;

    public CustomerConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
            System.out.println(environment.getProperty("info.app.description"));
        };
    }
}
```

But the correct way may be using @ConfigurationProperties annotation:
check InfoApp and InfoDB classes
