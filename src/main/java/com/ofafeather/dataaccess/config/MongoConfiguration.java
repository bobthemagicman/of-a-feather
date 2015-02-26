/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.dataaccess.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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
@EnableMongoRepositories("com.ofafeather.dataaccess.mongodb")
public class MongoConfiguration 
{

    @Configuration  
    @Profile("prod")  
    @PropertySource("classpath:dataaccess.properties")  
    static class Prod  
    {  
    }
    
    @Configuration  
    @Profile("dev")  
    @PropertySource("classpath:dataaccess.dev.properties")
    static class Dev  
    {  
    }  

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
