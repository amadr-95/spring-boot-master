# Proterties

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

But the correct way may be using `@ConfigurationProperties` annotation:
check InfoApp and InfoDB classes

# Profiles
We can add different profiles to work with and each one may have different settings
in order to work properly depending on whether we are developping on local or not

![profiles](src/main/resources/images/profiles.png)

By active one of the profiles:
- Pass de value as a program argument: `--spring.profiles.active=dev`
- 