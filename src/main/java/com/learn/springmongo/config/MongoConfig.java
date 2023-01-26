package com.learn.springmongo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

  @Value("${spring.data.mongodb.uri}")
  private String mongodbUri;

  @Value("${mongo.password")
  private String mongoPassword;

  @Bean
  public MongoClient mongo() throws Exception {
    final ConnectionString connectionString = new ConnectionString(mongodbUri.replace("<password>",mongoPassword));
    final MongoClientSettings mongoClientSettings =
        MongoClientSettings.builder().applyConnectionString(connectionString).build();
    return MongoClients.create(mongoClientSettings);
  }

  @Bean
  public MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongo(), "testdb");
  }
}
