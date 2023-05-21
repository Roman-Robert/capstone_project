package com.epam.racecup.model.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class AdminDTO {
    private UserDTO userEntity;
    private long id;
}
