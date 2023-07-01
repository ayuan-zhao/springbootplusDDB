package com.blackcowtech.core.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.blackcowtech.core.entity.BCTCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class CustomerRepository {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public CustomerRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public BCTCustomer save(BCTCustomer customer) {
        dynamoDBMapper.save(customer);
        return customer;
    }

    public BCTCustomer getCustomerById(String id) {
        return dynamoDBMapper.load(BCTCustomer.class, id);
    }

    // add other necessary methods...
}
