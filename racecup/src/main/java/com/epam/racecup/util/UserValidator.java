package com.epam.racecup.util;

import com.epam.racecup.model.dto.UserDTO;
import com.epam.racecup.model.entity.UserEntity;
import com.epam.racecup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserValidator implements Validator {
    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;

        Optional<UserEntity> userByEmail = userService.getUserByEmail(user.getEmail());

        if (userByEmail.isPresent()) {
            errors.rejectValue("email", "", "This email is already registered");
        }

        Optional<UserEntity> userByUsername = userService.getUserByUsername(user.getUsername());

        if (userByUsername.isPresent()) {
            errors.rejectValue("username", "", "This username is already registered");
        }

    }
}
