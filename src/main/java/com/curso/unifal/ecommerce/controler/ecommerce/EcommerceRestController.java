package com.curso.unifal.ecommerce.controler.ecommerce;

import com.curso.unifal.ecommerce.client.viacep.ViacepCLient;
import com.curso.unifal.ecommerce.domain.user.User;
import com.curso.unifal.ecommerce.service.ecommerce.EcommerceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EcommerceRestController {

    private final EcommerceService ecommerceService;
    private final ViacepCLient viacepCLient;

    @GetMapping(path = "/v1/zip-code")
    public ResponseEntity<?> getZipCodeInfoByZipCode(@RequestParam String zipCode) {
        return ResponseEntity.ok(viacepCLient.getZipCodeInfoByZipCode(zipCode));
    }

    @GetMapping(path = "/v1/ecommerce/user")
    public ResponseEntity<User> getUser(@RequestParam (required = false) String role) {
        User user =  ecommerceService.getUserByRole(role);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/v1/ecommerce/user")
    public String createUser(@RequestBody User user) {
        ecommerceService.createUser(user);
        return user.getRole();
    }

    @DeleteMapping(path = "/v1/ecommerce/user")
    public String deleteUser(@RequestParam (required = false) String user) {
        return ecommerceService.deleteUser(user);
    }

    @PutMapping(path = "/v1/ecommerce/user")
    public User updateUser(@RequestBody User user) {
        return ecommerceService.updateUser(user);
    }
}
