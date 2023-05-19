package com.epam.racecup.model.dto;

import com.epam.racecup.model.entity.UserEntity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class AdminDTO {
    private UserEntity userEntity;
    private long id;
}
