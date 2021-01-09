package com.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class AppConfig {

    @Autowired
    Environment environment;

    @Bean
    public DBConnection getDBConnection() {
        System.out.println("Getting DBConnection Bean from Application config");
        DBConnection connection = new DBConnection(
                environment.getProperty("jdbc.driverClass"),
                environment.getProperty("jdbc.jdbcUrl"),
                environment.getProperty("jdbc.user"),
                environment.getProperty("jdbc.pass")
                );

        return connection;
    }
}
