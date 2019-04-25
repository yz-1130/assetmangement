package com.cn.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.domain.Jijin;
import com.cn.service.JijinDao;
@Controller
	public class JijinController {
	@Autowired
		JijinDao   jijinDao;
	//goto management page
	@RequestMapping("Jijin-management.do")
	public String gotoJijin(Model model,HttpServletRequest req){
		Jijin jijin=new Jijin();
		HttpSession session = req.getSession(true);  
		User user=(User) session.getAttribute("user");
		if(!"管理员".equalsIgnoreCase(user.getRole())){
			jijin.setUserid(user.getId());
		}
		List<Jijin> qlist=jijinDao.selectJijin(jijin);
		model.addAttribute("result", qlist);
		return "Jijin-management";
}

		//查询
		@RequestMapping("selectJijin.do")
		public String selectJijin(Jijin jijin,Model model,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			if(!"管理员".equalsIgnoreCase(user.getRole())){
			jijin.setUserid(user.getId());
			}
			List<Jijin> qlist=jijinDao.selectJijin(jijin);
			model.addAttribute("result", qlist);
			return "Jijin-management";
		}
		
		//删除通知
		@RequestMapping("deleteJijin.do")
		public String deleteJijin(Jijin jijin){
			jijinDao.deleteJijin(jijin);
		return "redirect:Jijin-management.do";
		}
		
		//进入更新通知的页面
		@RequestMapping("gotoUpdateJijin.do")
		public String gotoUpdateJijin(Jijin jijin,Model model){
			List<Jijin> a=jijinDao.selectJijin(jijin);
			model.addAttribute("result",a);
			return "Jijin-update";
		}
		
		//修改通知
		@RequestMapping("updateJijin.do")
		public String updateJijin(Jijin jijin){
			jijinDao.updateJijin(jijin);
			return "redirect:Jijin-management.do";
		}
		
			//去新增页面
		@RequestMapping("Jijin-insert.do")
		public String gotoinsertJijin(){
			return "Jijin-insert";
		}
		
		//添加通知
		@RequestMapping("insertJijin.do")
		public String insertJijin(Jijin jijin,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			jijin.setUserid(user.getId());
			jijinDao.insertJijin(jijin);
			return "redirect:Jijin-management.do";
			}
}


