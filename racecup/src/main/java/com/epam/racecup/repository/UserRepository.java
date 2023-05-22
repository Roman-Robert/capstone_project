package com.epam.racecup.repository;

import com.epam.racecup.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Page<UserEntity> findAll(Pageable pageable);

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);
}
