package com.mvn_pro.project.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import com.mvn_pro.project.handler.LoginSuccessHandler;
import com.mvn_pro.project.handler.LogoutSuccessHandler;
import com.mvn_pro.project.security.filter.CustomUsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	@Autowired
	private CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter;

	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests().antMatchers("/", "/index", "/register", "/kaptcha").permitAll()
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll()
				.successHandler(loginSuccessHandler())
				.and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/index").permitAll()
				.logoutSuccessHandler(logoutSuccessHandler()).invalidateHttpSession(true)
				.and().rememberMe().rememberMeParameter("remember-me")
				.tokenValiditySeconds(1209600).tokenRepository(tokenRepository())
				.and().addFilterBefore(this.customUsernamePasswordAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.customUserDetailsService).passwordEncoder(passwordEncoder());

		auth.eraseCredentials(false);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	@Bean
	public JdbcTokenRepositoryImpl tokenRepository() {
		JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
		j.setDataSource(this.dataSource);
		return j;
	}

	@Bean
	public LoginSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new LogoutSuccessHandler();
	}
}
