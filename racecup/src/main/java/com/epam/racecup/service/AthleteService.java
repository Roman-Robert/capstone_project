package com.epam.racecup.service;

import com.epam.racecup.mapper.AthleteMapper;
import com.epam.racecup.model.dto.AthleteDTO;
import com.epam.racecup.model.dto.UserDTO;
import com.epam.racecup.model.entity.AthleteEntity;
import com.epam.racecup.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;
    private final AthleteMapper mapper;
    private final UserService userService;

    @Autowired
    public AthleteService(AthleteRepository athleteRepository, AthleteMapper mapper, UserService userService) {
        this.athleteRepository = athleteRepository;
        this.mapper = mapper;
        this.userService = userService;
    }

    public void saveAthlete(AthleteDTO athlete) {
        UserDTO user = userService.getUserById(athlete.getId());

        userService.updateUserToAthlete(user);
        athlete.setUser(user);

        AthleteEntity athleteEntity = mapper.dtoToEntity(athlete);

        athleteRepository.save(athleteEntity);
    }

    public Page<AthleteDTO> getAllAthletes(Pageable pageable) {
        Page<AthleteEntity> athleteEntities = athleteRepository.findAll(pageable);
        return athleteEntities.map(mapper::entityToDto);
    }

    public AthleteDTO getAthleteById(long id) {
        return mapper.entityToDto(athleteRepository.getOne(id));
    }
}