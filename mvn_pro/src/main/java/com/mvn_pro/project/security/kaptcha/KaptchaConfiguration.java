package com.mvn_pro.project.security.kaptcha;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.mvn_pro.project.utils.PathUtils;

@Configuration
@EnableAutoConfiguration
public class KaptchaConfiguration {
	
	private static Properties properties = new Properties();

	static {
		try {
			properties.load(new FileInputStream(File.separator + PathUtils.getTomcatClassesPath() + "/application.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Bean
	public Producer captchaProducer() {
		DefaultKaptcha kaptcha = new DefaultKaptcha();
		Config config = new Config(properties);
		kaptcha.setConfig(config);
		return kaptcha;
	}
}
