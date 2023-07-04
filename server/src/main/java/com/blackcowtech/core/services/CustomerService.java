package com.blackcowtech.core.services;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.blackcowtech.core.dto.BCTCustomerTbl;
import com.blackcowtech.core.entity.BCTCustomer;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private DynamoDBMapper mapper;

    public void addCustomer(BCTCustomer customer) {
        // 1. add customer to DDB
        // 2. return customer.
        // 3. test demo
        System.out.println("email :: " + customer.getCustomerEmail());
        System.out.println("full name :: " + customer.getCustomerName());
        String id = UUID.randomUUID().toString();
        System.out.println("customer id :: " + id);
        customer.setCustomerId(id);

        BCTCustomerTbl customerTbl = new BCTCustomerTbl();
        customerTbl.setCustomerEmail(customer.getCustomerEmail());
        customerTbl.setCustomerLastName(customer.getCustomerName());
        customerTbl.setCustomerId(id);
        mapper.save(customerTbl);
    }
}
