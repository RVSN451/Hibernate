package com.example.hibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("KOST").password("{noop}2222").roles("ALL")
                .and().withUser("RVSN").password("{noop}2222").roles("READ");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin()
                .and()
                .authorizeRequests().antMatchers("/hello**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/goodbye**").authenticated()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city**",
                        "/persons/TheSpecifiedNameAndSurname**").hasAnyRole("ALL", "READ")
                .and()
                .authorizeRequests().antMatchers("/persons/LessTheSpecifiedAge**").hasRole("ALL");
    }

}
