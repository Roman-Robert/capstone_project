package com.epam.racecup.config;

import com.epam.racecup.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/images/**")
                .permitAll()
                .antMatchers("/**/*.js", "/**/*.css")
                .permitAll()
                .antMatchers("/user/all", "/user/{id:[0-9]+}", "/user/set_role").hasRole("ADMIN")
                .antMatchers("/race/new", "/race/edit/*", "/race/delete/*", "/result/{id:[0-9]+}/set_result").hasAnyRole("ORGANIZER", "ADMIN")
                .antMatchers("/rating/**", "/athlete/{id:[0-9]+}/new").hasAnyRole("USER", "ATHLETE", "ORGANIZER", "ADMIN")
                .antMatchers("/login", "/user/new", "/", "/mainpage", "/race/schedule", "/result", "/result/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
        .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/mainpage", true)
                .failureUrl("/login?error")
                .and()
        .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}