package com.spring.student.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * The below code helps to override the spring default security and it allows
	 * all request , it will not authenticate and authorise any request
	 */
	/*
	 * @Override public void configure(HttpSecurity httpSecurity) throws Exception {
	 * httpSecurity .authorizeHttpRequests() .anyRequest() .permitAll() .and()
	 * .httpBasic(); httpSecurity.csrf().disable(); }
	 */

	/*
	 * The below code helps to authenticate and authorize users based on user name
	 * and password. since i am using the spring boot verion 2.7.8 it expects
	 * password encoder as noop password encoder so we are using {noop}password as
	 * parameter to password
	 * 
	 */
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("siddu").password("{noop}password").
	 * roles("ADMIN")
	 * .and().withUser("Datta").password("{noop}password").roles("USER"); }
	 */

	// All the api's are accessible by all the users no restrictions on user role
	/*
	 * @Override public void configure(HttpSecurity httpSecurity) throws Exception {
	 * httpSecurity .authorizeHttpRequests() .anyRequest() .authenticated() .and()
	 * .httpBasic();
	 * 
	 * 
	 * httpSecurity.csrf().disable(); }
	 */
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests()
					.antMatchers("/student/updateStudent").hasAnyRole("USER","ADMIN")
					.antMatchers("/book/**").hasAnyRole("ADMIN")
					.antMatchers("/user").authenticated()
					.antMatchers("/swagger-ui").permitAll()
					.and()
					.httpBasic();

		httpSecurity.csrf().disable();
	}
	
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
