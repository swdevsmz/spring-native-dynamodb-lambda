package com.swdevsmz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {
    Region awsRegion = Region.AP_NORTHEAST_1;

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder().region(awsRegion).build();
    }

    @Bean
    public String tableName() {
        return "users";
    }
}
