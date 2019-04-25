package com.cn.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.domain.Fangdai;
import com.cn.service.FangdaiDao;
@Controller
	public class FangdaiController {
	@Autowired
		FangdaiDao   fangdaiDao;
	//goto management page
	@RequestMapping("Fangdai-management.do")
	public String gotoFangdai(Model model,HttpServletRequest req){
		Fangdai fangdai=new Fangdai();
		HttpSession session = req.getSession(true);  
		User user=(User) session.getAttribute("user");
		if(!"管理员".equalsIgnoreCase(user.getRole())){
			fangdai.setUserid(user.getId());
		}
		List<Fangdai> qlist=fangdaiDao.selectFangdai(fangdai);
		model.addAttribute("result", qlist);
		return "Fangdai-management";
}

		//查询
		@RequestMapping("selectFangdai.do")
		public String selectFangdai(Fangdai fangdai,Model model,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			if(!"管理员".equalsIgnoreCase(user.getRole())){
			fangdai.setUserid(user.getId());
			}
			List<Fangdai> qlist=fangdaiDao.selectFangdai(fangdai);
			model.addAttribute("result", qlist);
			return "Fangdai-management";
		}
		
		//删除通知
		@RequestMapping("deleteFangdai.do")
		public String deleteFangdai(Fangdai fangdai){
			fangdaiDao.deleteFangdai(fangdai);
		return "redirect:Fangdai-management.do";
		}
		
		//进入更新通知的页面
		@RequestMapping("gotoUpdateFangdai.do")
		public String gotoUpdateFangdai(Fangdai fangdai,Model model){
			List<Fangdai> a=fangdaiDao.selectFangdai(fangdai);
			model.addAttribute("result",a);
			return "Fangdai-update";
		}
		
		//修改通知
		@RequestMapping("updateFangdai.do")
		public String updateFangdai(Fangdai fangdai){
			fangdaiDao.updateFangdai(fangdai);
			return "redirect:Fangdai-management.do";
		}
		
			//去新增页面
		@RequestMapping("Fangdai-insert.do")
		public String gotoinsertFangdai(){
			return "Fangdai-insert";
		}
		
		//添加通知
		@RequestMapping("insertFangdai.do")
		public String insertFangdai(Fangdai fangdai,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			fangdai.setUserid(user.getId());
			fangdaiDao.insertFangdai(fangdai);
			return "redirect:Fangdai-management.do";
			}
}


