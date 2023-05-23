package com.epam.racecup.security;

import com.epam.racecup.model.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final UserDTO user;


    public UserDetails(UserDTO user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; //TODO: implement access rights
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    //TODO:implement logic with deleted accounts(is_active)
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

    //needed to get authenticated user data
    public UserDTO getUser() {
        return this.user;
    }
}
