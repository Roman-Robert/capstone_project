package com.epam.racecup.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class OrganizerDTO {

    @NotNull
    private UserDTO user;

    @NotNull
    private long id;

    @NotEmpty(message = "Contacts cannot be empty")
    private String mobilePhone;
}
