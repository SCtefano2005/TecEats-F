package com.teceats.teceatsapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/customers/register", "/api/restaurant-owners/register", "/oauth2/**", "/login/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/oauth2/authorization/google")  // Página de inicio de sesión con Google
                        .defaultSuccessUrl("/api/customers")  // Redirigir al iniciar sesión exitosamente
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")  // Redirigir al home al cerrar sesión
                );
        return http.build();
    }
}