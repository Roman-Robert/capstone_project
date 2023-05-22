package com.epam.racecup.model.dto;

import com.epam.racecup.model.RaceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class RaceDTO {
    private long id;
//    @NotEmpty(message = "Race type should be selected")
    private RaceType raceType;

    @NotEmpty(message = "Race name cannot be empty")
    @Size(min = 3, max = 45, message = "Race name should be between 3 and 45 characters")
    private String name;

    @NotEmpty(message = "Location cannot be empty")
    @Size(min = 3, max = 45, message = "Race name should be between 3 and 64 characters")
    private String location;

//    @NotEmpty(message = "Distance cannot be empty")
    @Min(value = 0, message = "Distance should be greater zero")
    private Double distanceKm;

//    @NotEmpty(message = "Date cannot be empty")
    private Date date;

    @NotEmpty(message = "Info cannot be empty")
    @Size(min = 1, max=255, message = "Race info should be between 1 and 255 characters")
    private String info;

    //реализовать автозаполнение на айдишник админа
//    @NotEmpty
    private long organizerId;
//    @NotEmpty
    private int isActual;
}
