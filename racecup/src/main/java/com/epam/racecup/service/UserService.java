package com.epam.racecup.service;

import com.epam.racecup.dao.UserRepository;
import com.epam.racecup.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.getOne(id);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
