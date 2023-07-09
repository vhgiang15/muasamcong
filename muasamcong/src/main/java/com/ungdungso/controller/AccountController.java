package com.ungdungso.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import com.ungdungso.model.Account;
import com.ungdungso.model.Email;
import com.ungdungso.service.AccountService;
import java.util.Properties;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/register-user")
	public ModelAndView registerUser(@RequestParam(value = "fullName", required = true, defaultValue = "null") String fullName,
			@RequestParam(value = "user", required = true, defaultValue = "null") String user,
			@RequestParam(value = "phone", required = true, defaultValue = "null") String phone,
			@RequestParam(value = "mail", required = true, defaultValue = "null") String mail) throws UnsupportedEncodingException, MessagingException {
		ModelAndView model = new ModelAndView("client/alert");
		String pass = RandomStringUtils.randomAlphanumeric(8);
		String hashPass = BCrypt.hashpw(pass, BCrypt.gensalt(12));
		Account account = new Account(user, fullName, phone, mail, hashPass, "ROLE_USER", "enable");		
		System.out.println(fullName);
		System.out.println(user);
		System.out.println(phone);
		System.out.println(mail);
		if(fullName.equals("null")||user.equals("null")||phone.equals("null")||mail.equals("null")) {
			model.addObject("show", "show");
			model.addObject("message", "Thông tin chưa đầy đủ");

			return model;		
		}
		
		if (accountService.isExistUserName(user)) {
			model.addObject("show", "show");
			model.addObject("message", "Username đã tồn tại");

			return model;
		}
		if (accountService.isExistUserMail(mail)) {
			model.addObject("show", "show");
			model.addObject("message", "Mail đã tồn tại");

			return model;
		}
		if (accountService.isExistUserPhone(phone)) {
			model.addObject("show", "show");
			model.addObject("message", "Số điện thoại đã tồn tại ");

			return model;
		}
		accountService.addAccount(account);
		sendPass(account,pass);
		model.addObject("show", "show");
		model.addObject("message", "Đăng ký thành công! Mật khẩu đã gửi vào mail");

		return model;
	}
	
	//Chức năng reset Pass áp dụng được cho tất cả các user, chỉ reset pass cho chính mình
		@RequestMapping("/reset-pass")
		public ModelAndView resetPassUser(@RequestParam("email") String email)
				throws MessagingException, UnsupportedEncodingException {
			ModelAndView model = new ModelAndView("client/alert");
			System.out.println(email);
			if (accountService.isExistUserMail(email)) {
				Account account = accountService.getByEmail(email);
				if(account.getAvailable().equalsIgnoreCase("disable"))
				{
					model.addObject("show", "show");
					model.addObject("message", "User bị khóa. Vui lòng liên hệ Admin");
					return model;
					
				}
				String pass = RandomStringUtils.randomAlphanumeric(8);
				String hashPass = BCrypt.hashpw(pass, BCrypt.gensalt(12));
				account.setPass(hashPass);
				accountService.saveAccount(account);
				sendPass(account,pass);				
				model.addObject("show", "show");
				model.addObject("message", "Mật khẩu mới đã gửi vào email");
				return model;
			} else {
				model.addObject("show", "show");
				model.addObject("message", "Email không tồn tại");
				return model;
			}
		}

	
	
	
	
	
	
	
	private void sendPass(Account account, String pass) throws MessagingException, UnsupportedEncodingException
	{
		
		Email emailObject = new Email();
		emailObject.setEmailSubject("Thông tin mật khẩu mới");
		emailObject.setEmailText("Mật khẩu mới của user "+account.getUserName()+" là: " + pass + " .Vui lòng thực hiện đôi mật khẩu");
		emailObject.setEmailTo(account.getMail());

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Email.userName, Email.pass);
			}
		};
		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		// set message headers
		msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		msg.addHeader("format", "flowed");
		msg.addHeader("Content-Transfer-Encoding", "8bit");
		msg.setFrom(new InternetAddress(Email.emailFrom, "NoReply-JD"));
		msg.setReplyTo(InternetAddress.parse(Email.emailFrom, false));
		msg.setSubject(emailObject.getEmailSubject(), "UTF-8");
		msg.setText(emailObject.getEmailText(), "UTF-8");
		msg.setSentDate(new Date());
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailObject.getEmailTo(), false));
		Transport.send(msg);
		
	}

}
