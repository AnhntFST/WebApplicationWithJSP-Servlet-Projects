package ams4.Package.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ams4.Package.dao.AccountDAO;
import ams4.Package.model.Administrator;

@Controller
public class LoginController {
	
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping(value= "/loginForm", method = RequestMethod.GET)
	public ModelAndView loginForm(ModelAndView model) {
		Administrator account = new Administrator();
		model.addObject("account", account);
		model.setViewName("login");
		return model;
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public ModelAndView loginAccount(@RequestParam("email") String email, @RequestParam("password") String pass,ModelAndView model ) {
		Administrator theAccount = new Administrator();
		Administrator requestInfo = new Administrator(email, pass);
		
		//String email = account.getEmail();
		//String pass = account.getPassword();
		theAccount = accountDAO.getAccount(email, pass);
		String message = "";
		
		if (theAccount != null) {
			message = email.split("@")[0];
			model.addObject("message", message);
			model.setViewName("admin");
		}else {
			message = "Email dang nhap hoac mat khau khong chinh xac";
			model.addObject("message", message);
			model.addObject("inputInfo", requestInfo);
			model.setViewName("login");
		}
		return model;
	}
}
