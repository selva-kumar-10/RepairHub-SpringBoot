package com.repairHub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.repairHub.service.AdminUserDetailsService;
@Configuration
@EnableWebSecurity
public class AdminSecurityConfig {
	
	@Autowired
	private AdminUserDetailsService adminUserDetailsService;

	@Bean
	public SecurityFilterChain adminSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf->csrf.disable())
		.securityMatcher("/admin/**","/admin-login.html","/admin/doLogin")
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/admin-register.html", "/admin/register", "/admin-login.html","/admin/doLogin").permitAll()
				.requestMatchers(HttpMethod.POST,"/admin/service/add").hasRole("ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				)
		.formLogin(login -> login
				.loginPage("/admin-login.html")
				.loginProcessingUrl("/admin/doLogin")
				.defaultSuccessUrl("/admin/dashboard", true).permitAll()
				)
		.userDetailsService(adminUserDetailsService)
		.logout(logout -> logout
				.logoutUrl("/admin/logout")
				.logoutSuccessUrl("/admin-login.html")
				);
		return http.build();
	}
	


}
