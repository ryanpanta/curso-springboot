package com.curso.unifal.ecommerce.domain.user;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String user;
    private String password;
    private String role;

}
