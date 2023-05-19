package com.epam.racecup.service;

import com.epam.racecup.dao.repository.OrganizerRepository;
import com.epam.racecup.mapper.OrganizerMapper;
import com.epam.racecup.model.dto.OrganizerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;
    private final OrganizerMapper mapper;

    @Autowired
    public OrganizerService(OrganizerRepository organizerRepository,
                            OrganizerMapper mapper) {
        this.organizerRepository = organizerRepository;
        this.mapper = mapper;
    }

    public void saveOrganizer(OrganizerDTO organizer) {
        organizerRepository.save(mapper.dtoToEntity(organizer));
    }

    public List<OrganizerDTO> getAllOrganizers() {
        return organizerRepository
                .findAll()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
