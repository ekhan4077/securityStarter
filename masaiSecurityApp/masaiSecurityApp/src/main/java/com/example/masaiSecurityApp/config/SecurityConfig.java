package com.example.masaiSecurityApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//	@Bean
//	  public SecurityFilterChain masaiSecurityConfig(HttpSecurity http) throws Exception {
//
//			http.authorizeHttpRequests( (auth)->auth
//					.requestMatchers("/masai/welcomeP").authenticated()
//					.requestMatchers("/masai/welcome").permitAll()
//			).httpBasic();
//
//			return http.build();
//	  }
	@Bean
	public SecurityFilterChain masaiSecurityConfig(HttpSecurity http) throws Exception {
	
	
		http.authorizeHttpRequests( (auth)->auth
				.requestMatchers("/masai/welcomeP").authenticated()
				.requestMatchers("/masai/admin").hasRole("ADMIN")
				.requestMatchers("/masai/employee/register","/masai/welcome").permitAll()
				
		).csrf().disable()
		.httpBasic();
	
		return http.build();
}

	@Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	 }
	
//	@Bean
//	public InMemoryUserDetailsManager userDetails() {
//	
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//	    UserDetails admin = User.withUsername("ejaz").password("12345").authorities("admin").build();
//	    UserDetails user = User.withUsername("Arun").password("12345").authorities("read").build();
//	    userDetailsService.createUser(admin);
//	    userDetailsService.createUser(user);
//	    return userDetailsService;
//	}
	
//	@Bean
//	 public PasswordEncoder passwordEncoder() {
//	        return NoOpPasswordEncoder.getInstance();
//	 }
}
