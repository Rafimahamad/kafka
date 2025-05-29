package com.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class OktaConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {

        httpSecurity
                .authorizeExchange(authorize->
                        authorize.pathMatchers("/auth/login","/auth/**").permitAll()
                        .anyExchange().authenticated())
                .oauth2Client(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .logout(ServerHttpSecurity.LogoutSpec::disable);


        return httpSecurity.build();
    }

//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
//        return httpSecurity
//
//                .authorizeExchange(auth -> auth
//                        .anyExchange().authenticated()
//                )
//                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable) // Disable HTTP Basic
//                .formLogin(ServerHttpSecurity.FormLoginSpec::disable) // Disable Form Login
//                .oauth2Client(Customizer.withDefaults())
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
//                .build();
//    }
}
