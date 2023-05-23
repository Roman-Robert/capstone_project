package com.epam.racecup.service;

import com.epam.racecup.mapper.UserMapper;
import com.epam.racecup.model.entity.UserEntity;
import com.epam.racecup.repository.UserRepository;
import com.epam.racecup.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserDetailsService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(username));

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return new UserDetails(userMapper.entityToDto(user.get()));
    }
}
