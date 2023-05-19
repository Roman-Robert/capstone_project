package com.epam.racecup.mapper;

import com.epam.racecup.model.dto.AthleteDTO;
import com.epam.racecup.model.entity.AthleteEntity;
import org.springframework.stereotype.Component;

@Component
public class AthleteMapper {
    private final UserMapper mapper;

    public AthleteMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    public AthleteDTO entityToDto(AthleteEntity athleteEntity){
        return AthleteDTO.builder()
                .user(mapper.entityToDto(athleteEntity.getUser()))
                .id(athleteEntity.getId())
                .birthday(athleteEntity.getBirthday())
                .gender(athleteEntity.getGender())
                .country(athleteEntity.getCountry())
                .city(athleteEntity.getCity())
                .team(athleteEntity.getTeam())
                .build();
    }

    public AthleteEntity dtoToEntity(AthleteDTO athleteDTO){
        return AthleteEntity.builder()
                .user(mapper.dtoToEntity(athleteDTO.getUser()))
                .id(athleteDTO.getId())
                .birthday(athleteDTO.getBirthday())
                .gender(athleteDTO.getGender())
                .country(athleteDTO.getCountry())
                .city(athleteDTO.getCity())
                .team(athleteDTO.getTeam())
                .build();
    }
}
