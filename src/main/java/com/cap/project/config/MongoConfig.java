package com.cap.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class MongoConfig {
    // Empty: annotation enables @CreatedDate/@LastModifiedDate support
}
