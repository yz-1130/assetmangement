package com.cn.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.service.RegisterDao;
@Controller
public class RegisterController {
	
	@Autowired
	RegisterDao registedao;
	
	@RequestMapping("regaccess.do")
	public String reg(User  user){
		user.setStatus("P");
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String sendTime = sf.format(new Date()); 
		user.setApplyDate(sendTime);
		if(registedao.insertuser(user)){
			return "login";
		}else{
			return "login-err";
		}
		
	}
	
	@RequestMapping("register-management.do")
	public String showRegister(Model model){
		List<User> userList=registedao.showRegister();
		model.addAttribute("b",userList);
		
		return "register-management";
		
	}
	
	@RequestMapping("deleteUserQ.do")
	public String deleteUserQ(User user){
		int a =registedao.deleteUserQ(user);
		
		return "redirect:register-management.do";
		
	}
	
	@RequestMapping("approveUserQ.do")
	public String approveUserQ(User user){
		int a =registedao.approveUserQ(user);
		
		return "redirect:register-management.do";
		
	}
	
	

	@RequestMapping("selectuserByID.do")
	public String selectuserByID(User user,Model model){
		
		List<User> userList=registedao.selectuserByID(user);
		model.addAttribute("b",userList);
		return "register-management";
		
	}
	

	@RequestMapping("QdangyuanInfo-management.do")
	public String gotoDangYuan(Model model){
		
		List<User> userList=registedao.showAllUser();
		model.addAttribute("b",userList);
			return "QdangyuanInfo-management";
		
	}
	
	

	
	
	
	
	
		//goto 鍏氳垂璁＄畻鍣�
		
		@RequestMapping("QDangFeiCalucate-management.do")
		public String QDangFeiCalucate(){
			
			return "QDangFeiCalucate";
			
		}
	
		//goto瀛︾敓鍏氳垂璁＄畻鍣�
		
		@RequestMapping("QStudentDangFei-management.do")
		public String QStudentDangFei(){
			
			return "QStudentDangFei";
			
		}
		
	
		
		
		
		//鍘绘柊澧為〉闈�
		@RequestMapping("Qnotice-insert.do")
		public String gotoinsertQnotice(){
			
			
			return "Qnotice-insert";
			
		}
		
		//娣诲姞閫氱煡
	
		
			
			//鍘诲厖鍊奸〉闈�
			@RequestMapping("Xchongzhi-management.do")
			public String gotoChongZhi(HttpServletRequest req,Model model){
				HttpSession session=req.getSession();
				User user=(User) session.getAttribute("user");
				List<User> userList=registedao.selectuserByID(user);
				model.addAttribute("b",userList);
				//return "register-management";
				return "Xchongzhi-management";
				
			}
			
			//杩涜鍏呭�兼搷浣�
			
			@RequestMapping("chongzhiByID.do")
			public String ChongZhi(HttpServletRequest req,Model model,User userq){
				HttpSession session=req.getSession();
				User user=(User) session.getAttribute("user");
				
				registedao.chongzhiForUser(user);
				
				List<User> userList=registedao.selectuserByID(user);
			
				model.addAttribute("b",userList);
				
				//return "register-management";
				return "Xchongzhi-management";
				
			}
			
			
			
			
		

}
