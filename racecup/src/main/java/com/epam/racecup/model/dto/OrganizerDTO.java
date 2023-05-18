package com.epam.racecup.model.dto;

import com.epam.racecup.model.entity.UserEntity;
import lombok.Data;

@Data
public class OrganizerDTO {
    private UserEntity userEntity;
    private long id;
    private String mobilePhone;
}
