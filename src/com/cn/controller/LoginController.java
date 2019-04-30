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

import com.cn.service.LoginDao;



@Controller
@SessionAttributes(value={"drivers","waiters","lines"})
public class LoginController {
	@Autowired
	LoginDao login;


	@RequestMapping("loginaccess.do")
	public String checkuser(User user1,HttpServletRequest req,Model model){
		User ret = login.checkuser(user1);

		if(ret!=null){
			
			HttpSession session = req.getSession(true);  
			session.setAttribute("user",ret); 
			  
			return "main";
		}
		else{
			return "loginfail";
		}
	}

	
	 @RequestMapping("loginout.do")
	    public String outLogin(HttpSession session){
	        //通过session.invalidata()方法来注销当前的session
	        session.invalidate();
	        return "login";
	    }

}
