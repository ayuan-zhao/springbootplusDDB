package com.blackcowtech.core.services;

    import com.blackcowtech.core.entity.BCTCustomer;
    import com.blackcowtech.core.entity.BCTUser;
    import java.util.UUID;
    import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void addUser(BCTUser user) {
        // 1. add customer to DDB
        // 2. return customer.
        // 3. test demo
        System.out.println("email :: " + user.getUserEmail());
        System.out.println("full name :: " + user.getUserName());
        String id = UUID.randomUUID().toString();
        System.out.println("user id :: " + id);
        user.setUserId(id);
    }
}
