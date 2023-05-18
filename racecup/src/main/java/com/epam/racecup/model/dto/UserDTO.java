package com.epam.racecup.model.dto;

import com.epam.racecup.model.Role;
import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int isActive = 1;
    private String role = Role.ROLE_USER.getRole();
}
