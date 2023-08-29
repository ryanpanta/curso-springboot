package com.curso.unifal.ecommerce.service.ecommerce;

import com.curso.unifal.ecommerce.domain.user.User;

import org.springframework.stereotype.Service;

@Service
public class EcommerceService {

    public User getUserByRole(String role){
        if (role == null || role.isEmpty() ) {
            return null;
        }
        return new User();
    }
    public void createUser(User user) {

    }
    public String deleteUser(String username) {
        if(username == null || username.isEmpty()){
            return "ALL USERS DELETED";
        }
        return "User: " + username + " deleted.";
    }


    public User updateUser(User updatedUser) {
        User userAlreadyCreated = new User();
        userAlreadyCreated.setUser("panta");
        userAlreadyCreated.setPassword("213");
        userAlreadyCreated.setRole("mecanico");
        userAlreadyCreated = updatedUser;

        return userAlreadyCreated;
    }

}
