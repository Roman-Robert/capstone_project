package com.epam.racecup.service;

import com.epam.racecup.dao.repository.AthleteRepository;
import com.epam.racecup.dao.repository.UserRepository;
import com.epam.racecup.mapper.AthleteMapper;
import com.epam.racecup.model.Role;
import com.epam.racecup.model.dto.AthleteDTO;
import com.epam.racecup.model.dto.UserDTO;
import com.epam.racecup.model.entity.AthleteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;
    private final UserRepository userRepository;
    private final AthleteMapper mapper;
    private final UserService userService;

    @Autowired
    public AthleteService(AthleteRepository athleteRepository, UserRepository userRepository, AthleteMapper mapper, UserService userService) {
        this.athleteRepository = athleteRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.userService = userService;
    }

    public void saveAthlete(AthleteDTO athlete) {
        //changing user role to admin
        UserDTO user = userService.getUserById(athlete.getId());
        user.setRole(Role.ROLE_ATHLETE.getRole());
        userService.updateUser(user);
        //adding user to athlete field
        athlete.setUser(user);
        //saving athlete
        AthleteEntity athleteEntity = mapper.dtoToEntity(athlete);
        athleteRepository.save(athleteEntity);
    }

    public Page<AthleteDTO> getAllAthletes(Pageable pageable) {
        Page<AthleteEntity> athleteEntities = athleteRepository.findAll(pageable);
        return athleteEntities.map(mapper::entityToDto);
    }

}
