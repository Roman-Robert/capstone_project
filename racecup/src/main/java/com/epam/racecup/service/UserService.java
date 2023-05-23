package com.epam.racecup.service;

import com.epam.racecup.mapper.UserMapper;
import com.epam.racecup.model.Role;
import com.epam.racecup.model.dto.UserDTO;
import com.epam.racecup.model.entity.UserEntity;
import com.epam.racecup.repository.UserRepository;
import com.epam.racecup.util.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserMapper mapper,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserDTO user) {
        user.setFirstName(StringFormatter.format(user.getFirstName()));
        user.setLastName(StringFormatter.format(user.getLastName()));
        user.setRole(Role.ROLE_USER.getRole());
        user.setIsActive(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(mapper.dtoToEntity(user));
    }

    public void updateUser(UserDTO user) {
        UserDTO oldUser = getUserById(user.getId());

        user.setFirstName(StringFormatter.format(user.getFirstName()));
        user.setLastName(StringFormatter.format(user.getLastName()));
        user.setPassword(oldUser.getPassword());
        user.setIsActive(oldUser.getIsActive());
        user.setRole(oldUser.getRole());
        userRepository.save(mapper.dtoToEntity(user));
    }

    public void deleteUser(UserDTO user) {
        user.setIsActive(0);
        userRepository.save(mapper.dtoToEntity(user));
    }

    public Page<UserDTO> getAllUsers(Pageable pageable) {
        Page<UserEntity> userEntities = userRepository.findAll(pageable);
        return userEntities.map(mapper::entityToDto);
    }

    public UserDTO getUserById(long id) {
        return mapper.entityToDto(userRepository.getOne(id));
    }

    public void updateUserRole(UserDTO user) {
        UserDTO updatedUser = getUserById(user.getId());
        updatedUser.setRole(user.getRole());
        updateUser(updatedUser);
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    public Optional<UserEntity> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}
