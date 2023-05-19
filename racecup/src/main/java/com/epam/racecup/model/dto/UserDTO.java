package com.epam.racecup.model.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserDTO {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int isActive;
    private String role;
}
