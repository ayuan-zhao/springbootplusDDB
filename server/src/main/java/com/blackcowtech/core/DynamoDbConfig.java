package com.blackcowtech.core;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfig {

    @Value("${amazon.access.key}")
    private String awsAccessKey;

    @Value("${amazon.access.secret-key}")
    private String awsSecretKey;

    @Value("${amazon.end-point.url}")
    private String awsDynamoDBEndPoint;

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
    }

    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
        return new AWSStaticCredentialsProvider(amazonAWSCredentials());
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamoDBEndPoint, ""))
            .withCredentials(amazonAWSCredentialsProvider())
            .build();
    }

    @Bean
    public DynamoDBMapper mapper() {
        return new DynamoDBMapper(amazonDynamoDB());
    }

    @Bean
    public DynamoDBMapper mapper2() {
//        return new DynamoDBMapper(amazonDynamoDB());
//        String accessKey = awsAccessKey;
//        String secretKey = awsSecretKey;
//        BasicSessionCredentials awsCreds = new BasicSessionCredentials(accessKey, secretKey, "IQoJb3JpZ2luX2VjEKX//////////wEaCXVzLWVhc3QtMiJIMEYCIQCe+0Y+RbbMFisdp7VSK4yWq5fJsx8Od7MJw5WLaeCGCgIhAN+cI9lYqJqOwswCfxM9g7Gl+NGa1yWhr/fv+wBfz0mOKu4CCB4QABoMNzQ1NTExNzU2NzAxIgy9gMy4+iy9vt8BwS4qywIygNNZ5+kwiR+zGXmZgoP8pjTpz6bj0cDzXnSiMr3YTWiQWZyqj0N2FUpiKKlEBLpDM6GQu7+ZyGb85JqCBF+CZoplDq6ezCcqAvczI84Gye9lX9EtCmGKohOlsnnZBEGddgB2uo1HW6tlwMElf/7geUJQXLfBl03xyowX1MqE1kdeN+u+1FdC3btIu7IeEFkEVxv7ivKbUA2XESCcvleJlW6S/K39wQNd+Lahw7FDxX63To+Ytu4gSfWk02SNtTwsLwlw9VM0t4UHU++9PjgfC5awfFj/sbafVdBZberKUfatQPap9nfnNoV2n/ifvmsLd6oVvMXFCb0N25Y+kk1w8/r4s7l7tRm6+K3EufMvhvQ2XntPiQcixaWqPx4UCeAIJpJ3pSEBru5AyQxFYW9lnvrUDckvKaFKCTzPSRa/lcbsHEwaAgwBGElYMICSkqUGOqYBGrUqj3CdnX1DiwggemuqvtPHfcbkc6mEEa2bu7rnXmruo2/B42QWSPZGokHbT48G/z6GFRwriu9J/Xz84BKxFDPYo2v9x9CAc4OoY3AzHkmCAW5CFbFLN/E7yc23vzZQ2E0L1+CKMbJ8+9aGm622jz646wLWqcEuJCBuA/3NlQuV68qgNYwoHZFdhn1ZyrrZ5YAUVRfu/T9FsrsLT4e4AWV3PssW9Q==");
//
//        AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.standard()
//            .withRegion("us-east-2") //choose the appropriate region
//            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//            .build();
//
//
//
//        // Now you can use the DynamoDB client for CRUD operations, for example
//        ListTablesResult tableList = dynamoDB.listTables();
//        for (String tableName : tableList.getTableNames()) {
//            System.out.println(tableName);
//        }

        String accessKey = "ASIA23E7WUOOVUE2PNMJ";
        String secretKey = "+oVnBBQearEWOxDN5xMDNyZ6gk4kYniOrVPnb42L";
        String sessionToken = "IQoJb3JpZ2luX2VjEKX//////////wEaCXVzLWVhc3QtMiJIMEYCIQCe+0Y+RbbMFisdp7VSK4yWq5fJsx8Od7MJw5WLaeCGCgIhAN+cI9lYqJqOwswCfxM9g7Gl+NGa1yWhr/fv+wBfz0mOKu4CCB4QABoMNzQ1NTExNzU2NzAxIgy9gMy4+iy9vt8BwS4qywIygNNZ5+kwiR+zGXmZgoP8pjTpz6bj0cDzXnSiMr3YTWiQWZyqj0N2FUpiKKlEBLpDM6GQu7+ZyGb85JqCBF+CZoplDq6ezCcqAvczI84Gye9lX9EtCmGKohOlsnnZBEGddgB2uo1HW6tlwMElf/7geUJQXLfBl03xyowX1MqE1kdeN+u+1FdC3btIu7IeEFkEVxv7ivKbUA2XESCcvleJlW6S/K39wQNd+Lahw7FDxX63To+Ytu4gSfWk02SNtTwsLwlw9VM0t4UHU++9PjgfC5awfFj/sbafVdBZberKUfatQPap9nfnNoV2n/ifvmsLd6oVvMXFCb0N25Y+kk1w8/r4s7l7tRm6+K3EufMvhvQ2XntPiQcixaWqPx4UCeAIJpJ3pSEBru5AyQxFYW9lnvrUDckvKaFKCTzPSRa/lcbsHEwaAgwBGElYMICSkqUGOqYBGrUqj3CdnX1DiwggemuqvtPHfcbkc6mEEa2bu7rnXmruo2/B42QWSPZGokHbT48G/z6GFRwriu9J/Xz84BKxFDPYo2v9x9CAc4OoY3AzHkmCAW5CFbFLN/E7yc23vzZQ2E0L1+CKMbJ8+9aGm622jz646wLWqcEuJCBuA/3NlQuV68qgNYwoHZFdhn1ZyrrZ5YAUVRfu/T9FsrsLT4e4AWV3PssW9Q==";

        BasicSessionCredentials awsCreds = new BasicSessionCredentials(accessKey, secretKey, sessionToken);

        AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.standard()
            .withRegion("us-east-2") //choose the appropriate region
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .build();

        // Now you can use the DynamoDB client for CRUD operations, for example
        ListTablesResult tableList = dynamoDB.listTables();
        for (String tableName : tableList.getTableNames()) {
            System.out.println(tableName);
        }
        return new DynamoDBMapper(dynamoDB);
    }
}