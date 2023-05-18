package com.epam.racecup.service;

import com.epam.racecup.dao.repository.OrganizerRepository;
import com.epam.racecup.model.entity.OrganizerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;

    @Autowired
    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public void saveOrganizer(OrganizerEntity organizer) {
        organizerRepository.save(organizer);
    }

    public List<OrganizerEntity> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public OrganizerEntity getOrganizerById(long id) {
        return organizerRepository.getOne(id);
    }
}
