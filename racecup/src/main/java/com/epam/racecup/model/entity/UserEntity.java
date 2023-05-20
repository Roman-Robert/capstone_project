package com.epam.racecup.model.entity;

import com.epam.racecup.model.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private int isActive = 1;

    @Column(name = "role")
    private String role = Role.ROLE_USER.getRole();


    //////////////////////////////////////////////
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AthleteEntity athlete;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AdminEntity admin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private OrganizerEntity organizer;
}