package com.cn.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.domain.Baoxian;
import com.cn.service.BaoxianDao;
@Controller
	public class BaoxianController {
	@Autowired
		BaoxianDao   baoxianDao;
	//goto management page
	@RequestMapping("Baoxian-management.do")
	public String gotoBaoxian(Model model,HttpServletRequest req){
		Baoxian baoxian=new Baoxian();
		HttpSession session = req.getSession(true);  
		User user=(User) session.getAttribute("user");
		if(!"管理员".equalsIgnoreCase(user.getRole())){
			baoxian.setUserid(user.getId());
		}
		List<Baoxian> qlist=baoxianDao.selectBaoxian(baoxian);
		model.addAttribute("result", qlist);
		return "Baoxian-management";
}

		//查询
		@RequestMapping("selectBaoxian.do")
		public String selectBaoxian(Baoxian baoxian,Model model,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			if(!"管理员".equalsIgnoreCase(user.getRole())){
			baoxian.setUserid(user.getId());
			}
			List<Baoxian> qlist=baoxianDao.selectBaoxian(baoxian);
			model.addAttribute("result", qlist);
			return "Baoxian-management";
		}
		
		//删除通知
		@RequestMapping("deleteBaoxian.do")
		public String deleteBaoxian(Baoxian baoxian){
			baoxianDao.deleteBaoxian(baoxian);
		return "redirect:Baoxian-management.do";
		}
		
		//进入更新通知的页面
		@RequestMapping("gotoUpdateBaoxian.do")
		public String gotoUpdateBaoxian(Baoxian baoxian,Model model){
			List<Baoxian> a=baoxianDao.selectBaoxian(baoxian);
			model.addAttribute("result",a);
			return "Baoxian-update";
		}
		
		//修改通知
		@RequestMapping("updateBaoxian.do")
		public String updateBaoxian(Baoxian baoxian){
			baoxianDao.updateBaoxian(baoxian);
			return "redirect:Baoxian-management.do";
		}
		
			//去新增页面
		@RequestMapping("Baoxian-insert.do")
		public String gotoinsertBaoxian(){
			return "Baoxian-insert";
		}
		
		//添加通知
		@RequestMapping("insertBaoxian.do")
		public String insertBaoxian(Baoxian baoxian,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			baoxian.setUserid(user.getId());
			baoxianDao.insertBaoxian(baoxian);
			return "redirect:Baoxian-management.do";
			}
}


