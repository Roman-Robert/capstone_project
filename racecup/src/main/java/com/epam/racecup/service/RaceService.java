package com.epam.racecup.service;

import com.epam.racecup.dao.repository.RaceRepository;
import com.epam.racecup.mapper.RaceMapper;
import com.epam.racecup.model.dto.RaceDTO;
import com.epam.racecup.model.entity.RaceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final RaceMapper mapper;

    @Autowired
    public RaceService(RaceRepository raceRepository, RaceMapper mapper) {
        this.raceRepository = raceRepository;
        this.mapper = mapper;
    }

    public void saveRace(RaceDTO race) {
        raceRepository.save(mapper.dtoToEntity(race));
    }

    public Page<RaceDTO> getAllRaces(Pageable pageable) {
        Page<RaceEntity> raceEntities = raceRepository.findAll(pageable);
        return raceEntities.map(mapper::entityToDto);
    }

    public RaceDTO getRaceById(long id) {
        return mapper.entityToDto(raceRepository.getOne(id));
    }

    public Page<RaceDTO> findByDateAfter(Date date, Pageable pageable) {
        Page<RaceEntity> raceEntities = raceRepository.findByDateAfter(date, pageable);
        return raceEntities.map(mapper::entityToDto);
    }

    public List<RaceDTO> findByDateBefore(Date date) {
        return raceRepository.findByDateBefore(date)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
