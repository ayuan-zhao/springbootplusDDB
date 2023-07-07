
package com.blackcowtech.core.services;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.blackcowtech.core.dto.BCTCustomerTbl;
import com.blackcowtech.core.entity.BCTCustomer;
import java.util.Arrays;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import java.util.List;

//business logic
@Service
public class CustomerService {

    @Autowired
    private DynamoDBMapper mapper;


    //    public void addCustomer(BCTCustomer customer) {
//        System.out.println("email :: " + customer.getCustomerEmail());
//        System.out.println("full name :: " + customer.getCustomerName());
//        String id = UUID.randomUUID().toString();
//        System.out.println("customer id :: " + id);
//        customer.setCustomerId(id);
//
//        BCTCustomerTbl customerTbl = new BCTCustomerTbl();
//        customerTbl.setCustomerEmail(customer.getCustomerEmail());
//        customerTbl.setCustomerLastName(customer.getCustomerName());
//        customerTbl.setCustomerId(id);
//        mapper.save(customerTbl);
//    }
    public void addCustomer(BCTCustomer customer) {
        System.out.println("email:: " + customer.getCustomerEmail());
        System.out.println("full name :: " + customer.getCustomerName());
        String id = UUID.randomUUID().toString();
        System.out.println("customer id :: " + id);
        customer.setCustomerId(id);
        String[] names = customer.getCustomerName().split(" ");
        // Create a new instance of BCTCustomerTbl to store customer information
        BCTCustomerTbl customerTbl = new BCTCustomerTbl();
        customerTbl.setCustomerEmail(customer.getCustomerEmail());
        customerTbl.setCustomerId(id);
        if (names.length == 1) {
            customerTbl.setCustomerLastName(names[0]);

        } else if (names.length == 2) {
            customerTbl.setCustomerFirstName(names[0]);
            customerTbl.setCustomerLastName(names[1]);
        } else {
            customerTbl.setCustomerFirstName(names[0]);
            customerTbl.setCustomerLastName(names[names.length - 1]);
            String middleNames = String.join("", Arrays.copyOfRange(names, 1, names.length - 1));
            customerTbl.setCustomerMiddleName(middleNames.replace("", "."));
        }
        mapper.save(customerTbl);
        System.out.println("customerTbl :: " + customerTbl);
    }

    public BCTCustomerTbl getCustomerById(String customerId) {
        BCTCustomerTbl customerKey = new BCTCustomerTbl();
        customerKey.setCustomerId(customerId);
        return mapper.load(BCTCustomerTbl.class, customerKey);
    }

    public List<BCTCustomerTbl>getAllCustomers(){
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<BCTCustomerTbl>customerList = mapper.scan(BCTCustomerTbl.class,scanExpression);
        return customerList;

    }

//    public void updateCustomer(BCTCustomer customer) {
//        //find which part need update
//        BCTCustomerTbl existingCustomer = getCustomerById(customer.getCustomerId());
//        if(existingCustomer == null){
//            throw new RuntimeException("Customer with id " + customer.getCustomerId() + " not found");
//        }
//
//        if(customer.getCustomerEmail() != null){
//            existingCustomer.setCustomerEmail(customer.getCustomerEmail());
//        }
//
//        if(customer.getCustomerName() != null){
//            String[] nameParts = customer.getCustomerName().split(" ");
//            switch (nameParts.length) {
//                case 1:
//                    existingCustomer.setCustomerLastName(nameParts[0]);
//                    break;
//                case 2:
//                    existingCustomer.setCustomerFirstName(nameParts[0]);
//                    existingCustomer.setCustomerLastName(nameParts[1]);
//                    break;
//                case 3:
//                    existingCustomer.setCustomerFirstName(nameParts[0]);
//                    existingCustomer.setCustomerMiddleName(nameParts[1]);
//                    existingCustomer.setCustomerLastName(nameParts[2]);
//                    break;
//                default:
//                    existingCustomer.setCustomerFirstName(nameParts[0]);
//                    existingCustomer.setCustomerMiddleName(String.join(".", Arrays.copyOfRange(nameParts, 1, nameParts.length - 1)));
//                    existingCustomer.setCustomerLastName(nameParts[nameParts.length - 1]);
//            }
//        }
//
//        mapper.save(existingCustomer);
//    }

//        System.out.println("email :: " + customer.getCustomerEmail());
//        System.out.println("full name :: " + customer.getCustomerName());
//        String id = UUID.randomUUID().toString();
//        System.out.println("customer id :: " + id);
//        customer.setCustomerId(id);


}
