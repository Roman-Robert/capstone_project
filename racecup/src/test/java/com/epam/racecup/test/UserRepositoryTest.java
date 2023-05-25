package com.epam.racecup.test;

import com.epam.racecup.config.JpaConfig;
import com.epam.racecup.model.entity.UserEntity;
import com.epam.racecup.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
@SpringBootTest
@Transactional
//@ActiveProfiles("test")
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
        UserEntity userTest = UserEntity.builder()
                .username("user_test")
                .firstName("User_firstname")
                .lastName("User_lastname")
                .email("email-email@email.com")
                .password("password")
                .isActive(1)
                .role("User")
                .build();
        userRepository.save(userTest);

        UserEntity userCheck = userRepository.findByEmail(userTest.getEmail());
        assertEquals(userTest, userCheck);
    }

    @Test
    public void deleteUserTest() {
        UserEntity userTest = UserEntity.builder()
                .username("user_test")
                .firstName("User_firstname")
                .lastName("User_lastname")
                .email("test_email@email.com")
                .password("password")
                .isActive(1)
                .role("User")
                .build();

        userRepository.save(userTest);
        userRepository.delete(userTest);
        assertNull(userRepository.findByUsername(userTest.getUsername()));
    }


}
