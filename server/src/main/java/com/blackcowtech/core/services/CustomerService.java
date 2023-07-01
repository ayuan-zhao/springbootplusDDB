package com.blackcowtech.core.services;

import com.blackcowtech.core.entity.BCTCustomer;
import com.blackcowtech.core.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository ){
        this.customerRepository = customerRepository;
    }

    public void addCustomer(BCTCustomer customer) {
        customerRepository.save(customer);
        // 1. add customer to DDB
        // 2. return customer.
        // 3. test demo
//        System.out.println("email :: " + customer.getCustomerEmail());
//        System.out.println("full name :: " + customer.getCustomerName());
//        String id = UUID.randomUUID().toString();
//        System.out.println("customer id :: " + id);
//        customer.setCustomerId(id);
    }
}
