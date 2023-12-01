package com.lean.demoSpringSecurity.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.lean.demoSpringSecurity.service.WebSecuritiConfig;

import jakarta.annotation.security.PermitAll;

@Configuration
@EnableWebSecurity
public class AppConfig    {
	@Autowired
	private JwtAuthenticationFilter jwtTokenFilter;
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http,  HandlerMappingIntrospector introspector)  throws Exception{
		http.csrf(csrf ->{
			csrf.disable();
		});
		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
		http.headers().frameOptions().disable();
		http.authorizeHttpRequests(authz -> {
			
			authz.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
			
			.requestMatchers(mvcMatcherBuilder.pattern("/user/v1/**")).permitAll()
			
			.anyRequest().authenticated();
		}).httpBasic(Customizer.withDefaults());
		http.addFilterBefore(jwtTokenFilter,UsernamePasswordAuthenticationFilter.class);
//		http.httpBasic(ele -> ele..s);
		return http.build();
	}
	
	
	@Bean
    public AuthenticationManager authenticationManager(
                                 AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
