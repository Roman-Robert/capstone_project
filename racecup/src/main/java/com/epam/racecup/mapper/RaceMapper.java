package com.epam.racecup.mapper;

import com.epam.racecup.model.dto.RaceDTO;
import com.epam.racecup.model.entity.RaceEntity;
import org.springframework.stereotype.Component;

@Component
public class RaceMapper {

    public RaceDTO entityToDto(RaceEntity raceEntity){
        return RaceDTO.builder()
                .id(raceEntity.getId())
                .raceType(raceEntity.getRaceType())
                .name(raceEntity.getName())
                .location(raceEntity.getLocation())
                .distanceKm(raceEntity.getDistanceKm())
                .date(raceEntity.getDate())
                .info(raceEntity.getInfo())
                .organizerId(raceEntity.getOrganizerId())
                .isActual(raceEntity.getIsActual())
                .build();
    }

    public RaceEntity dtoToEntity(RaceDTO raceDTO){
        return RaceEntity.builder()
                .id(raceDTO.getId())
                .raceType(raceDTO.getRaceType())
                .name(raceDTO.getName())
                .location(raceDTO.getLocation())
                .distanceKm(raceDTO.getDistanceKm())
                .date(raceDTO.getDate())
                .info(raceDTO.getInfo())
                .organizerId(raceDTO.getOrganizerId())
                .isActual(raceDTO.getIsActual())
                .build();
    }
}
