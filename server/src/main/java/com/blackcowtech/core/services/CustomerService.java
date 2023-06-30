package com.blackcowtech.core.services;

import com.blackcowtech.core.entity.BCTCustomer;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public void addCustomer(BCTCustomer customer) {
        // 1. add customer to DDB
        // 2. return customer.
        // 3. test demo
        System.out.println("email :: " + customer.getCustomerEmail());
        System.out.println("full name :: " + customer.getCustomerName());
        String id = UUID.randomUUID().toString();
        System.out.println("customer id :: " + id);
        customer.setCustomerId(id);
    }
}
