//package com.api.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class OAuth2Configuaration {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()  // Use authorizeRequests() here (since authorizeHttpRequests is deprecated)
//                .requestMatchers("/", "/login", "/error").permitAll()  // Allow these URLs without authentication
//                .anyRequest().authenticated()  // Require authentication for all other URLs
//                .and()
//                .oauth2Login()  // Enable OAuth2 login (like GitHub login)
//                .and()
//                .logout().permitAll();  // Allow logout for everyone
//
//        return http.build();
//    }
//}
