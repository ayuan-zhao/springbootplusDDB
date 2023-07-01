package com.blackcowtech.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.util.List;




@DynamoDBTable(tableName = "Customers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BCTCustomer {

    @DynamoDBHashKey(attributeName = "CustomerId")
    @JsonProperty("customer_id")
    private String customerId;

    @DynamoDBAttribute(attributeName = "CustomoerName")
    @JsonProperty("customer_name")
    private String customerName;

    @DynamoDBAttribute(attributeName = "CustomerEmail")
    @JsonProperty("customer_email")
    private String customerEmail;
    //Assuming ContactInfo is another class holding contact related details

    @DynamoDBAttribute(attributeName = "Services")
//    List of service Ids

    private List<String> services;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
