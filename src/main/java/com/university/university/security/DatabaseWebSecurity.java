/*package com.university.university.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select s.document_number,s.id from user as u "
				+ "inner join student as s on s.user = u.id "+
				" where s.document_number =?").
				authoritiesByUsernameQuery(
						"select p.name from profile p " +
							"inner join user u on u.id_profile = p.id_profile " +
						    "where u.id = ?");

	}

	
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests().antMatchers("/bootstrap/**", "/img/**",
	  "/tinymce/**", "/css/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll
	  ().and().logout() .permitAll(); ; }
	 

}
*/