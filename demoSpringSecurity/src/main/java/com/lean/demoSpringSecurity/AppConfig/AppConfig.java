package com.lean.demoSpringSecurity.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.annotation.security.PermitAll;

@Configuration
@EnableWebSecurity
public class AppConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http)  throws Exception{
		http.csrf(csrf ->{
			csrf.disable();
		});
		http.headers().frameOptions().disable();
		http.authorizeHttpRequests(authz -> {
			authz.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll();
			authz.anyRequest().authenticated();
		});
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
