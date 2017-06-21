package com.inovia.cars.rest.configuration;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 *
 */
@ComponentScan(basePackages = "com.inovia.cars.rest.domain")
@EnableMongoRepositories(basePackages = "com.inovia.cars.rest.repository")
@Configuration
public class FongoConfiguration extends AbstractMongoConfiguration {

    private static final String DATABASE_NAME = "cars-application";
    private static final String FONGO_SERVER_NAME = "cars-server";

    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Bean
    @Override
    public Mongo mongo() throws Exception {
        return new Fongo(FONGO_SERVER_NAME).getMongo();
    }
}
