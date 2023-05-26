package com.epam.racecup.service;

import com.epam.racecup.mapper.OrganizerMapper;
import com.epam.racecup.model.dto.OrganizerDTO;
import com.epam.racecup.model.dto.UserDTO;
import com.epam.racecup.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;
    private final UserService userService;
    private final OrganizerMapper mapper;

    @Autowired
    public OrganizerService(OrganizerRepository organizerRepository,
                            UserService userService, OrganizerMapper mapper) {
        this.organizerRepository = organizerRepository;
        this.userService = userService;
        this.mapper = mapper;
    }

    public void saveOrganizer(OrganizerDTO organizer) {
        UserDTO user = userService.getUserById(organizer.getId());
        userService.updateUserToOrganizer(user);
        organizer.setUser(user);
        organizerRepository.save(mapper.dtoToEntity(organizer));
    }

    public List<OrganizerDTO> getAllOrganizers() {
        return organizerRepository
                .findAll()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    public OrganizerDTO getOrganizerById(long id) {
        return mapper.entityToDto(organizerRepository.getOne(id));
    }
}