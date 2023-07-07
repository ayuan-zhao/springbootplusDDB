//define our API URLs and use the service class to manage data.

package com.blackcowtech.core.controller;


import com.blackcowtech.core.dto.BCTCustomerTbl;
import com.blackcowtech.core.entity.BCTCustomer;
import com.blackcowtech.core.services.CustomerService;
import com.fasterxml.jackson.databind.JsonNode;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/customer")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //test URL: http://localhost:8080/api/v1/customer/all
    @GET
    @Path("/all")
//    public List<BCTCustomer> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }
    public String getAllCustomers() {
        return "Hello world2!";
    }


    @GET
    @Path("/test")
    public JsonNode testJson() {
        return null;
    }

    //test URL: http://localhost:8080/api/v1/customer/ POST
    @POST
    public BCTCustomer addCustomer(BCTCustomer customer) {
        // 1. new CustomerService
//        CustomerService customerService = new CustomerService();
//        customerService.addCustomer(customer);

        // 2. Spring, using Autowired
        customerService.addCustomer(customer);
        return customer;
    }

    //    http://localhost:8080/api/v1/customer/health
    @GET
    @Path("/health")
    public Response healthCheck() {
        return Response.status(Response.Status.OK)
            .entity("Service is running").build();
    }

    @GET
    @Path("/getCustomerById")
    public BCTCustomerTbl getCustomerById(@PathParam("customerId") String customerId) {
        return customerService.getCustomerById(customerId);
    }


}