package com.blackcowtech.core;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import com.amazonaws.auth.AWSStaticCredentialsProvider;

import org.springframework.context.annotation.Configuration;

public class DynamoDBConfig {

    @Value("${aws.accessKeyId}")
    private String amazonAWSAccessKey;

    @Value("${aws.secretKey}")
    private String amazonAWSSecretKey;

    @Value("${aws.region}")
    private String amazonAWSRegion;

    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()))
            .withRegion(amazonAWSRegion)
            .build();
    }

    @Bean
    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDBMapper(amazonDynamoDB);
    }
}