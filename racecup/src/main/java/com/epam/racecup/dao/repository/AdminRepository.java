package com.epam.racecup.dao.repository;

import com.epam.racecup.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
