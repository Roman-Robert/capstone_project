package com.epam.racecup.mapper;

import com.epam.racecup.model.dto.OrganizerDTO;
import com.epam.racecup.model.entity.OrganizerEntity;
import org.springframework.stereotype.Component;

@Component
public class OrganizerMapper {

    public OrganizerDTO entityToDto(OrganizerEntity organizerEntity) {
        return OrganizerDTO.builder()
                .user(organizerEntity.getUser())
                .id(organizerEntity.getId())
                .mobilePhone(organizerEntity.getMobilePhone())
                .build();
    }

    public OrganizerEntity dtoToEntity(OrganizerDTO organizerDTO) {
        return OrganizerEntity.builder()
                .user(organizerDTO.getUser())
                .id(organizerDTO.getId())
                .mobilePhone(organizerDTO.getMobilePhone())
                .build();
    }
}
