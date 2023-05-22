package com.epam.racecup.model.dto;

import com.epam.racecup.model.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class AthleteDTO {

    @NotNull(message = "User cannot be null")
    private UserDTO user;

    @NotNull(message = "Id cannot be null")
    private long id;

    @NotNull(message = "Date cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotNull(message = "Gender cannot be null")
    private Gender gender;

    @NotEmpty(message = "Country cannot be empty")
    @Size(max=45, message = "Country name cannot be greater than 45 characters")
    private String country;

    @Size(max=45, message = "City name cannot be greater than 45 characters")
    private String city;

    @Size(max=45, message = "Team name cannot be greater than 45 characters")
    private String team;

    private int place;

    private String group;

}
