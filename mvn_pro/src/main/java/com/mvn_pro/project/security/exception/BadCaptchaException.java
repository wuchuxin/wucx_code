package com.mvn_pro.project.security.exception;

import org.springframework.security.core.AuthenticationException;

public class BadCaptchaException extends AuthenticationException {
	
	private static final long serialVersionUID = -4214126206407574089L;

	public BadCaptchaException(String msg) {
		super(msg);
	}
}
