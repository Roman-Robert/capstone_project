package com.epam.racecup.service;

import com.epam.racecup.dao.repository.OrganizerRepository;
import com.epam.racecup.model.Organizer;
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

    public void saveOrganizer(Organizer organizer) {
        organizerRepository.save(organizer);
    }

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Organizer getOrganizerById(long id) {
        return organizerRepository.getOne(id);
    }
}
