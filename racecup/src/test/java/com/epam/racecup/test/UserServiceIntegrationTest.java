package com.epam.racecup.test;

import com.epam.racecup.config.Config;
import com.epam.racecup.mapper.UserMapper;
import com.epam.racecup.model.Role;
import com.epam.racecup.model.dto.UserDTO;
import com.epam.racecup.model.entity.UserEntity;
import com.epam.racecup.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Config.class, UserService.class, PasswordEncoder.class, UserMapper.class, BCryptPasswordEncoder.class})
@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper mapper;

    @Test
    public void saveUser() {
        UserDTO userTest = userBuilder();
        long id = saveUserAndGetId(userTest);

        userTest.setId(id);

        UserDTO userCheck = userService.getUserById(id);

        assertNotNull(userCheck);
        assertEquals(userCheck, userTest);
    }

    @Test
    public void updateUserTest() {
        UserDTO userTest = userBuilder();
        long id = saveUserAndGetId(userTest);

        userTest.setId(id);

        String firstnameNew = "New Firstname";
        String lastnameNew = "New Lastname";
        String passwordNew = passwordEncoder.encode("New_password");

        userTest.setFirstName(firstnameNew);
        userTest.setLastName(lastnameNew);
        userTest.setPassword(passwordNew);

        userService.updateUser(userTest);

        UserDTO userCheck = userService.getUserById(id);

        assertNotNull(userCheck);
        assertEquals(userTest, userCheck);
    }

    @Test
    public void updateUserToOrganizerTest() {
        UserDTO user = userBuilder();
        long id = saveUserAndGetId(user);

        UserDTO userUpd = userService.getUserById(id);

        userService.updateUserToOrganizer(userUpd);

        UserDTO userCheck = userService.getUserById(id);

        assertNotNull(userCheck);
        assertEquals(userCheck.getRole(), Role.ROLE_ORGANIZER.getRole());
    }

    @Test
    public void updateUserToAthleteTest() {
        UserDTO user = userBuilder();
        long id = saveUserAndGetId(user);

        UserDTO userUpd = userService.getUserById(id);

        userService.updateUserToAthlete(userUpd);

        UserDTO userCheck = userService.getUserById(id);

        assertNotNull(userCheck);
        assertEquals(userCheck.getRole(), Role.ROLE_ATHLETE.getRole());
    }

    @Test
    public void deleteUserTest() {
        UserDTO userTest = userBuilder();
        long id = saveUserAndGetId(userTest);


        UserDTO userDel = userService.getUserById(id);
        userService.deleteUser(userDel);

        assertNotNull(userDel);
        assertEquals(userDel.getIsActive(), 0);
    }

    private UserDTO userBuilder() {
        return UserDTO.builder()
                .username("user_test")
                .firstName("User_firstname")
                .lastName("User_lastname")
                .email("test_email@email.com")
                .password(passwordEncoder.encode("password"))
                .isActive(1)
                .role("User")
                .build();
    }

    private Long saveUserAndGetId(UserDTO user) {
        userService.saveUser(user);
        return userService
                .getUserByUsername(user.getUsername())
                .map(UserEntity::getId)
                .orElse(null);
    }

}
