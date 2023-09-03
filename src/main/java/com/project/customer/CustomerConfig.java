package com.project.customer;

import com.project.info.InfoApp;
import com.project.info.InfoDB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfig {

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.version}")
    private String appVersion;

   /* private Environment environment;

    public CustomerConfig(Environment environment) {
        this.environment = environment;
    }*/

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp, InfoDB infoDB) {
        return args -> {
            System.out.println("Command line runner hooray");
            System.out.println("appName = " + appName);
            System.out.println("appVersion = " + appVersion);
            //System.out.println(environment.getProperty("info.app.description"));
            System.out.println("infoApp = " + infoApp);
            System.out.println("infoDB = " + infoDB);
        };
    }

}
