package com.mvn_pro.project.security.kaptcha;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Producer;
import com.mvn_pro.project.base.impl.BaseController;

@Controller
@RequestMapping({ "/kaptcha" })
public class CaptchaController extends BaseController {
	
	@Autowired
	private Producer captchaProducer;

	@RequestMapping
	public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("KAPTCHA_SESSION_KEY");
		System.out.println("����������" + code);

		response.setDateHeader("Expires", 0L);

		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		response.setHeader("Pragma", "no-cache");

		response.setContentType("image/jpeg");

		String capText = this.captchaProducer.createText();

		session.setAttribute("KAPTCHA_SESSION_KEY", capText);

		BufferedImage bi = this.captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();

		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}
}