package com.inquizit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/test/auth", "/auth/logout")
                    .authenticated()
                    .and()
                .authorizeRequests()
                    .antMatchers("/**")
                    .permitAll()
                    .and()
                .oauth2Login();

        return http.build();
    }

}
