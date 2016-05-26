package com.mvn_pro.project;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;

@SpringBootApplication
public class ApplicationMain extends SpringBootServletInitializer {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(new Object[] { ApplicationMain.class });
		sa.setShowBanner(false);
		sa.run(args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { ApplicationMain.class });
	}

	@Bean
	public Filter initializeHttpPutHandler() {
		return new HttpPutFormContentFilter();
	}

	@Bean
	public CharacterEncodingFilter initializeCharacterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
}
