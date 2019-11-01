package com.sts3.sample;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail/*")
public class MailController {
	Logger logger = LoggerFactory.getLogger(MailController.class);
	//true이면 주입받는 클래스가 없으면 예외발생시킴
	//false이면 클래스 없어도 런타임시 예외발생 안함.
	@Autowired(required=false)
	private JavaMailSender mailSender = null;
	@GetMapping(value = "mailSend")
	public String mailSend() {
		logger.info("mailSend 호출 성공");
		//insert here - 메일 제목, 메일 내용, 전송메소드 호출하기
		//보내는 사람 메일주소
		
		//받는 사람 메일 주소
		
		//메일 제목
		
		//메일 내용
		
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = 
					new MimeMessageHelper(msg,true,"UTF-8");
			msgHelper.setFrom(fromMail);
			msgHelper.setTo(toMail);
			msgHelper.setSubject(subject);
			msgHelper.setText(content);
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return "redirect:./mailSendOk.jsp";
	}
}







