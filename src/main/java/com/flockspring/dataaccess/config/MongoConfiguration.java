/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.dataaccess.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

/**
 * MongoConfiguration.java
 *
 * @author Justen L. Britain
 * @date Mar 29, 2014
 *
 */
@Configuration
@EnableMongoRepositories("com.flockspring.dataaccess.mongodb")
@PropertySource({"classpath:dataaccess.properties"})
public class MongoConfiguration 
{

    @Inject
    private Environment env;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception
    {
        Mongo mongo = new Mongo(env.getProperty("mongodb.host"), Integer.parseInt(env.getProperty("mongodb.port")));
        UserCredentials userCredentials = new UserCredentials(env.getProperty("mongodb.username"), env.getProperty("mongodb.password"));

        return new SimpleMongoDbFactory(mongo, env.getProperty("mongodb.dbName"), userCredentials);
        
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception
    {
        return new MongoTemplate(mongoDbFactory());
    }
}
