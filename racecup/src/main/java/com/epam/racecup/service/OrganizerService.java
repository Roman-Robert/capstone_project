package com.epam.racecup.service;

import com.epam.racecup.repository.OrganizerRepository;
import com.epam.racecup.mapper.OrganizerMapper;
import com.epam.racecup.model.Role;
import com.epam.racecup.model.dto.OrganizerDTO;
import com.epam.racecup.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;
    private final UserServiceImpl userService;
    private final OrganizerMapper mapper;

    @Autowired
    public OrganizerService(OrganizerRepository organizerRepository,
                            UserServiceImpl userService, OrganizerMapper mapper) {
        this.organizerRepository = organizerRepository;
        this.userService = userService;
        this.mapper = mapper;
    }

    public void saveOrganizer(OrganizerDTO organizer) {
        //changing user role to organizer
        UserDTO user = userService.getUserById(organizer.getId());
        user.setRole(Role.ROLE_ORGANIZER.getRole());
        userService.updateUser(user);
        //setting user to organizer field
        organizer.setUser(user);
        //saving organizer
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
