package com.sih.timetable.timetable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // allow ALL requests (GET + POST)
            )
            .formLogin(form -> form.disable()) // disable default login
            .httpBasic(httpBasic -> httpBasic.disable()); // disable basic auth

        return http.build();
    }
}
