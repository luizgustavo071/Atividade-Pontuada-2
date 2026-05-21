package com.example.atividade_pontuada_v2.config;

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
                // Desabilita o CSRF para permitir que rotas POST, PUT e DELETE funcionem sem tokens de sessão
                .csrf(csrf -> csrf.disable())

                // Define as regras de autorização das requisições HTTP
                .authorizeHttpRequests(auth -> auth
                        // .permitAll() diz ao Spring para liberar o acesso público a absolutamente todos os endpoints
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}