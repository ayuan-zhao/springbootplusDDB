package com.blackcowtech.core.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.blackcowtech.core.entity.BCTCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


//DAO（Data Access Object）
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

    public List<BCTCustomer> findAll() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        PaginatedScanList<BCTCustomer> scanList = dynamoDBMapper.scan(BCTCustomer.class, scanExpression);
        return scanList;
    }

    public void delete(BCTCustomer customer) {
        dynamoDBMapper.delete(customer);
    }
    public void deletedById(String id){
        BCTCustomer customer = getCustomerById(id);
        if(customer != null){
            dynamoDBMapper.delete(customer);
        }
    }

    public BCTCustomer update(BCTCustomer customer){
        dynamoDBMapper.save(customer);
        return customer;
    }
}


