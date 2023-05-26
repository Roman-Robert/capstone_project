package com.epam.racecup.security;

import com.epam.racecup.model.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private final UserDTO user;

    public UserDetailsImpl(UserDTO user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRole = user.getRole();
        String role = null;

        switch (userRole) {
            case "User":
                role = "ROLE_USER";
                break;
            case "Athlete":
                role = "ROLE_ATHLETE";
                break;
            case "Organizer":
                role = "ROLE_ORGANIZER";
                break;
            case "Admin":
                role = "ROLE_ADMIN";
        }
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserDTO getUser() {
        return this.user;
    }
}
