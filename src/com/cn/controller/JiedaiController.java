package com.cn.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.domain.Jiedai;
import com.cn.service.JiedaiDao;
@Controller
	public class JiedaiController {
	@Autowired
		JiedaiDao   jiedaiDao;
	//goto management page
	@RequestMapping("Jiedai-management.do")
	public String gotoJiedai(Model model,HttpServletRequest req){
		Jiedai jiedai=new Jiedai();
		HttpSession session = req.getSession(true);  
		User user=(User) session.getAttribute("user");
		if(!"管理员".equalsIgnoreCase(user.getRole())){
			jiedai.setUserid(user.getId());
		}
		List<Jiedai> qlist=jiedaiDao.selectJiedai(jiedai);
		model.addAttribute("result", qlist);
		return "Jiedai-management";
}

		//查询
		@RequestMapping("selectJiedai.do")
		public String selectJiedai(Jiedai jiedai,Model model,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			if(!"管理员".equalsIgnoreCase(user.getRole())){
			jiedai.setUserid(user.getId());
			}
			List<Jiedai> qlist=jiedaiDao.selectJiedai(jiedai);
			model.addAttribute("result", qlist);
			return "Jiedai-management";
		}
		
		//删除通知
		@RequestMapping("deleteJiedai.do")
		public String deleteJiedai(Jiedai jiedai){
			jiedaiDao.deleteJiedai(jiedai);
		return "redirect:Jiedai-management.do";
		}
		
		//进入更新通知的页面
		@RequestMapping("gotoUpdateJiedai.do")
		public String gotoUpdateJiedai(Jiedai jiedai,Model model){
			List<Jiedai> a=jiedaiDao.selectJiedai(jiedai);
			model.addAttribute("result",a);
			return "Jiedai-update";
		}
		
		//修改通知
		@RequestMapping("updateJiedai.do")
		public String updateJiedai(Jiedai jiedai){
			jiedaiDao.updateJiedai(jiedai);
			return "redirect:Jiedai-management.do";
		}
		
			//去新增页面
		@RequestMapping("Jiedai-insert.do")
		public String gotoinsertJiedai(){
			return "Jiedai-insert";
		}
		
		//添加通知
		@RequestMapping("insertJiedai.do")
		public String insertJiedai(Jiedai jiedai,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			jiedai.setUserid(user.getId());
			jiedaiDao.insertJiedai(jiedai);
			return "redirect:Jiedai-management.do";
			}
}


