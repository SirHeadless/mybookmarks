package com.sirheadless.mybookmarks;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	// https://dzone.com/articles/spring-security-4-authenticate-and-authorize-users
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/url/**", "/category/**").and().authorizeRequests().antMatchers("/**")
		.hasRole("USER").and().formLogin();
		
		
//		http.requestMatchers().antMatchers("/url/**", "/category/**").and().authorizeRequests().antMatchers("/**")
//				.hasRole("USER").and().httpBasic().authenticationEntryPoint(authEntryPoint);

		// http.csrf().disable().authorizeRequests()
		// .anyRequest()
		// .authenticated()
		// .and().httpBasic()
		// .authenticationEntryPoint(authEntryPoint);
	}

	@Autowired
	public void configureGlobal3(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("configureGlobal3");
//		auth.inMemoryAuthentication().withUser("john1234").password("password").roles("USER");
		// CHRISTOPH: Use this!?

//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery("select username,password, enabled from users where username=?");

	}

}