package com.epam.racecup.service;

import com.epam.racecup.dao.repository.UserRepository;
import com.epam.racecup.mapper.UserMapper;
import com.epam.racecup.model.Role;
import com.epam.racecup.model.dto.UserDTO;
import com.epam.racecup.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        user.setRole(Role.ROLE_USER.getRole());
        user.setIsActive(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(mapper.dtoToEntity(user));
    }

    public void updateUser(UserDTO user) {
        UserDTO oldUser = getUserById(user.getId());
        //Saving old password, isActive, role
        user.setPassword(oldUser.getPassword());
        user.setIsActive(oldUser.getIsActive());
        user.setRole(oldUser.getRole());
        userRepository.save(mapper.dtoToEntity(user));
    }

    public void deleteUser(UserDTO user) {
        //Changing User status 1->0
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
}
