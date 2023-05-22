package com.epam.racecup.model.dto;

import com.epam.racecup.model.RaceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class RaceDTO {
    private long id;

    @NotNull(message = "Race type should be selected")
    private RaceType raceType;

    @NotEmpty(message = "Race name cannot be empty")
    @Size(min = 3, max = 45, message = "Race name should be between 3 and 45 characters")
    private String name;

    @NotEmpty(message = "Location cannot be empty")
    @Size(min = 3, max = 45, message = "Race name should be between 3 and 64 characters")
    private String location;


    @NotNull(message = "Distance cannot be empty")
    @Positive(message = "Distance cannot be negative")
    @Min(value = 0, message = "Distance should be greater zero")
    private Double distanceKm;

    @NotNull(message = "Date cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotEmpty(message = "Info cannot be empty")
    @Size(min = 1, max = 255, message = "Race info should be between 1 and 255 characters")
    private String info;

    //TODO: implement autofill on the admin id
    @NotNull(message = "OrganizerId can not be empty")
    private long organizerId;

    @NotNull(message = "isActive can not be empty")
    private int isActual;
}
