package com.example.Task_Management_System.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/auth/login")
                .permitAll()
                .requestMatchers("/admin/auth/login")
                .permitAll()
                .requestMatchers("/add_task")
                .permitAll()
                .requestMatchers("/delete_task")
                .permitAll()
                .requestMatchers("/update_task/**")
                .hasAnyRole( "USER")
                .requestMatchers("/get_task")
                .hasAnyRole( "ADMIN", "USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService getuserDetailsService(){
        return new CustomUserDetailService();
    }

    //Encryption of password
    @Bean
    public BCryptPasswordEncoder getbCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    //This small code do all your work of comapring the password accessing it permit it....
    @Bean
    public DaoAuthenticationProvider getdaoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getuserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(getbCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }
}

