package com.keycloak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigurationURL {

    @Bean
    protected SecurityFilterChain secureUri(HttpSecurity http) throws Exception {

        http.
                cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request->
                        request.requestMatchers("/api/v1/**").authenticated()
                                .anyRequest().permitAll()
                )
                .oauth2ResourceServer(autheServer-> autheServer.jwt(Customizer.withDefaults() ));

        return http.build();
    }
}
