package com.blackcowtech.core.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "btcCustomer")
public class BCTCustomerTbl {
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerMiddleName;

    private String customerEmail;

    @DynamoDBHashKey(attributeName = "customerId")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @DynamoDBAttribute(attributeName = "customerFirstName")
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    @DynamoDBAttribute(attributeName = "customerLastName")
    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    @DynamoDBAttribute(attributeName = "customerMidName")
    public String getCustomerMiddleName() {
        return customerMiddleName;
    }

    public void setCustomerMiddleName(String customerMiddleName) {
        this.customerMiddleName = customerMiddleName;
    }

    @DynamoDBAttribute(attributeName = "customerEmail")
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "BCTCustomerDTO{" +
            "customerId='" + customerId + '\'' +
            ", customerFirstName='" + customerFirstName + '\'' +
            ", customerLastName='" + customerLastName + '\'' +
            ", customerMiddleName='" + customerMiddleName + '\'' +
            ", customerEmail='" + customerEmail + '\'' +
            '}';
    }
}
