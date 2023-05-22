package com.epam.racecup.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserDTO {
    private long id;

    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 3, max = 10, message = "Username should be between 3 and 10 characters")
    private String username;

    @NotEmpty(message = "Firstname cannot be empty")
    @Size(min = 1, max = 25, message = "Firstname should be between 2 and 25 characters")
    private String firstName;

    @NotEmpty(message = "Lastname cannot be empty")
    @Size(min = 1, max = 25, message = "Lastname should be between 2 and 25 characters")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email
    @Size(min = 6, max = 255, message = "Email should be between 6 and 255 characters")
    private String email;

    @NotEmpty(message = "Password cannot be empty.")
    @Size(min = 8, max = 255, message = "Password should be between 8 and 255 characters")
    private String password;

//    @NotEmpty
    private int isActive;
//    @NotEmpty
    private String role;
}
