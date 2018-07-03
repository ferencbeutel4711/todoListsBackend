package de.fbeutel.todolistsbackend.configuration;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

@Configuration
public class MongoConfiguration {

  private static final String MONGO_DB_URL = "localhost";
  private static final String MONGO_DB_NAME = "todoListsDB";

  @Bean
  public MongoTemplate mongoTemplate() throws IOException {
    final EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
    mongo.setBindIp(MONGO_DB_URL);
    final MongoClient mongoClient = mongo.getObject();
    return new MongoTemplate(mongoClient, MONGO_DB_NAME);
  }
}