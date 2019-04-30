package com.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cn.domain.User;

@Controller
@SessionAttributes(value={"u","Ocu","Oe","Om"})
public class LoginPage {
	

	@RequestMapping("login.do")
	public String login(){
		return "login";
	}
	@RequestMapping("register.do")
	public String register(HttpServletRequest req){
User ret = new User();
ret.setUsername("test");
			HttpSession session = req.getSession(true);  
	      session.setAttribute("user",ret);  
		
		return "register";
	}

	@RequestMapping("goods-insert.do")
	public String ginsert(){
		return "goods-insert";
	}
	@RequestMapping("client-insert.do")
	public String cinsert(){
		return "client-insert";
	}
	@RequestMapping("employee-insert.do")
	public String einsert(){
		return "employee-insert";
	}

	
	
	
}
