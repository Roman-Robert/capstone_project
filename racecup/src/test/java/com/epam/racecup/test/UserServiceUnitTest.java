package com.epam.racecup.test;

import com.epam.racecup.config.JpaConfig;
import com.epam.racecup.mapper.UserMapper;
import com.epam.racecup.model.Role;
import com.epam.racecup.model.dto.UserDTO;
import com.epam.racecup.model.entity.UserEntity;
import com.epam.racecup.repository.UserRepository;
import com.epam.racecup.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
@SpringBootTest
public class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserService userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserMapper mapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository, mapper, passwordEncoder);
    }

    @Test
    public void saveUserTest() {
        UserDTO userDTO = createUserDTO();
        UserEntity userEntity = createUserEntity();

        when(mapper.dtoToEntity(userDTO)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        userService.saveUser(userDTO);

        verify(userRepository, times(1)).save(userEntity);
    }

    @Test
    public void getUserByIdTest() {
        long id = 1;
        UserEntity userEntity = createUserEntity();
        UserDTO userDTO = createUserDTO();

        when(userRepository.getOne(id)).thenReturn(userEntity);
        when(mapper.entityToDto(userEntity)).thenReturn(userDTO);

        UserDTO result = userService.getUserById(id);

        assertEquals(userDTO, result);

    }

    @Test
    public void getUserByIdReturnNullWhenUserNotExist() {
        long userId = 1;

        when(userRepository.getOne(userId)).thenReturn(null);

        UserDTO result = userService.getUserById(userId);

        assertNull(result);
    }

    @Test
    public void getUserByEmailTest() {
        String email = "email@example.com";
        UserEntity userEntity = createUserEntity();

        when(userRepository.findByEmail(email)).thenReturn(userEntity);

        Optional<UserEntity> result = userService.getUserByEmail(email);

        assertEquals(userEntity, result.orElse(null));
    }

    @Test
    public void getUserByEmailNullCaseWhenUserNotExist() {
        String email = "email@example.com";

        when(userRepository.findByEmail(email)).thenReturn(null);

        Optional<UserEntity> result = userService.getUserByEmail(email);

        assertEquals(Optional.empty(), result);
    }


    private UserDTO createUserDTO() {
        return UserDTO.builder()
                .id(1)
                .username("user")
                .firstName("User_firstname")
                .lastName("User_lastname")
                .email("email@gmail.com")
                .password("password")
                .isActive(1)
                .role(Role.ROLE_USER.getRole())
                .build();
    }

    private UserEntity createUserEntity() {
        return UserEntity.builder()
                .id(1)
                .username("user")
                .firstName("User_firstname")
                .lastName("User_lastname")
                .email("email@gmail.com")
                .password("password")
                .isActive(1)
                .role(Role.ROLE_USER.getRole())
                .build();
    }
}

