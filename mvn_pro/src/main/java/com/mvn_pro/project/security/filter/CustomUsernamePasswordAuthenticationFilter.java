package com.mvn_pro.project.security.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.mvn_pro.project.security.exception.BadCaptchaException;

@Component
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	public static final String CAPTCHA_PARAMETER = "kaptchaCode";

	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("KAPTCHA_SESSION_KEY");

		String userCode = request.getParameter("kaptchaCode");

		this.logger.info("\r\nCaptcha code is " + code + ", and User'code is" + userCode);

		Boolean isCorrect = Boolean.valueOf((StringUtils.isNotBlank(code)) && (StringUtils.isNotBlank(userCode))
				&& (StringUtils.equals(code, userCode)));
		if (!isCorrect.booleanValue()) {
			throw new BadCaptchaException(
					this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCaptcha", "Bad captcha"));
		}
		return super.attemptAuthentication(request, response);
	}
}