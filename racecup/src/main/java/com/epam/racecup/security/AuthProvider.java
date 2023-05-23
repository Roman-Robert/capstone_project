package com.epam.racecup.security;

import com.epam.racecup.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    @Autowired
    public AuthProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        String password = authentication.getCredentials().toString();

        if(!password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,
                password,
                Collections.emptyList()); //list of rights
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
