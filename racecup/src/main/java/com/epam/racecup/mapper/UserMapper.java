package com.epam.racecup.mapper;

import com.epam.racecup.model.dto.UserDTO;
import com.epam.racecup.model.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO entityToDto(UserEntity userEntity) {
        return UserDTO.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .isActive(userEntity.getIsActive())
                .role(userEntity.getRole())
                .build();
    }

    public UserEntity dtoToEntity(UserDTO userDTO){
        return UserEntity.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .isActive(userDTO.getIsActive())
                .role(userDTO.getRole())
                .build();
    }
}