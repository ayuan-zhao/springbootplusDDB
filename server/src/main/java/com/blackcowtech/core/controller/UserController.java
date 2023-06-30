//
//define our API URLs and use the service class to manage data.

package com.blackcowtech.core.controller;


    import com.blackcowtech.core.entity.BCTUser;
    import com.blackcowtech.core.services.UserService;
    import com.fasterxml.jackson.databind.JsonNode;
    import javax.ws.rs.Consumes;
    import javax.ws.rs.GET;
    import javax.ws.rs.POST;
    import javax.ws.rs.Path;
    import javax.ws.rs.Produces;
    import javax.ws.rs.core.MediaType;
    import org.springframework.beans.factory.annotation.Autowired;

@Path("/user")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class UserController {

    @Autowired
   UserService userService;

    //test URL: http://localhost:8080/api/v1/user/all
    @GET
    @Path("/all")
    public String getAllUser() {
        return "Hello world3!";
    }

    @GET
    @Path("/test")
    public JsonNode testJson() {
        return null;
    }

    //test URL: http://localhost:8080/api/v1/customer/ POST
    @POST
    public BCTUser addUser(BCTUser user) {
        // 1. new CustomerService
//        CustomerService customerService = new CustomerService();
//        customerService.addCustomer(customer);

        // 2. Spring, using Autowired
       userService.addUser(user);
        return user;
    }
}