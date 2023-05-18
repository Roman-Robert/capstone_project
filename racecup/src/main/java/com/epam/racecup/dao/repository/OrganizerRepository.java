package com.epam.racecup.dao.repository;

import com.epam.racecup.model.entity.OrganizerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<OrganizerEntity, Long> {
}
