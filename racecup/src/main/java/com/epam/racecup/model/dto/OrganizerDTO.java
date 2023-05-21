package com.epam.racecup.model.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class OrganizerDTO {
    private UserDTO user;
    private long id;
    private String mobilePhone;
}
