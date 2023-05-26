package com.epam.racecup.mapper;

import com.epam.racecup.model.dto.OrganizerDTO;
import com.epam.racecup.model.entity.OrganizerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizerMapper {
    private final UserMapper userMapper;

    @Autowired
    public OrganizerMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public OrganizerDTO entityToDto(OrganizerEntity organizerEntity) {
        return OrganizerDTO.builder()
                .user(userMapper.entityToDto(organizerEntity.getUser()))
                .id(organizerEntity.getId())
                .mobilePhone(organizerEntity.getMobilePhone())
                .build();
    }

    public OrganizerEntity dtoToEntity(OrganizerDTO organizerDTO) {
        return OrganizerEntity.builder()
                .user(userMapper.dtoToEntity(organizerDTO.getUser()))
                .id(organizerDTO.getId())
                .mobilePhone(organizerDTO.getMobilePhone())
                .build();
    }
}