package com.example.springsecuringweb;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
// class anotated @EnableWebSecurity to enable Spring Security's web security support and provide the Spring MVC integration.
@EnableWebSecurity
// Extends WebsecurityConfigurerAdapter to override a couple of methods to set some specifcis of the web security configuration.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    //configure(HttpSecurity) methods definds which URL paths should be secured and which should not.
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                        .antMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated()
                        .and()
                .formLogin()
                        .loginPage("/login")
                        .permitAll()
                        .and()
                .logout()
                        .permitAll();
    }

    @Bean
    @Override
    // userDetailsService method sets up an in-memory user store with a single user.
    public UserDetailsService userDetailsService() {
            UserDetails user =
                    User.withDefaultPasswordEncoder()
                            .username("user")
                            .password("password")
                            .roles("USER")
                            .build();

            return new InMemoryUserDetailsManager(user);
    }

}