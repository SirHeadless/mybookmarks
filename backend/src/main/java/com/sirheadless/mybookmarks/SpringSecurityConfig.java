package com.sirheadless.mybookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

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
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/category/**", "/url/**").fullyAuthenticated().and().
                httpBasic().and().
                csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).
                usersByUsernameQuery("select username,password, enabled from users where username=?").
//		 DUMMY QUERY WITH STATIC ROLE https://stackoverflow.com/questions/36775601/spring-security-jdbc-authentication-without-authorization
        authoritiesByUsernameQuery("select username, 'ROLE_USER' from users where username=?");
//		 authoritiesByUsernameQuery("select username, role from user_roles where username=?");


    }

}