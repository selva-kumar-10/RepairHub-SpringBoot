package com.repairHub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.repairHub.service.AdminUserDetailsService;
import com.repairHub.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class CustomerSecurityConfig {
	
	@Autowired 
	CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public SecurityFilterChain CustomersecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf->csrf.disable())
		.securityMatcher("/customer/**","/customer-login.html","/customer/doLogin")
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/customer-register.html", "/customer/register", "/customer-login.html").permitAll()
				.requestMatchers(HttpMethod.POST,"/customer/service/all").hasRole("CUSTOMER")
				.requestMatchers("/customer/**").hasRole("CUSTOMER")
				.anyRequest().authenticated()
				)
		.formLogin(login -> login
				.loginPage("/customer-login.html")
				.loginProcessingUrl("/customer/doLogin")
				.defaultSuccessUrl("/customer/dashboard", true).permitAll()
				)
		.userDetailsService(customUserDetailsService)
		.logout(logout -> logout
				.logoutUrl("/customer/logout")
				.logoutSuccessUrl("/customer-login.html")
				);
		return http.build();
	}
	
}
