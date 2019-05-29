package com.cn.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.domain.Jingyin;
import com.cn.service.JingyinDao;
@Controller
	public class JingyinController {
	@Autowired
		JingyinDao   jingyinDao;
	//goto management page
	@RequestMapping("Jingyin-management.do")
	public String gotoJingyin(Model model,HttpServletRequest req){
		Jingyin jingyin=new Jingyin();
		HttpSession session = req.getSession(true);  
		User user=(User) session.getAttribute("user");
		if(!"管理员".equalsIgnoreCase(user.getRole())){
			jingyin.setUserid(user.getId());
		}
		List<Jingyin> qlist=jingyinDao.selectJingyin(jingyin);

		int sum = 0;
		for (Jingyin jingyin1 : qlist) {
			int jine;
			jine = jingyin1.getShijian();
			sum += jine;
		}
		int totalAssetsAmount = sum;
		model.addAttribute("totalAssetsAmount", totalAssetsAmount);
		model.addAttribute("result", qlist);
		return "Jingyin-management";
}

		//查询
		@RequestMapping("selectJingyin.do")
		public String selectJingyin(Jingyin jingyin,Model model,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			if(!"管理员".equalsIgnoreCase(user.getRole())){
			jingyin.setUserid(user.getId());
			}
			List<Jingyin> qlist=jingyinDao.selectJingyin(jingyin);
			model.addAttribute("result", qlist);
			return "Jingyin-management";
		}
		
		//删除通知
		@RequestMapping("deleteJingyin.do")
		public String deleteJingyin(Jingyin jingyin){
			jingyinDao.deleteJingyin(jingyin);
		return "redirect:Jingyin-management.do";
		}
		
		//进入更新通知的页面
		@RequestMapping("gotoUpdateJingyin.do")
		public String gotoUpdateJingyin(Jingyin jingyin,Model model){
			List<Jingyin> a=jingyinDao.selectJingyin(jingyin);
			model.addAttribute("result",a);
			return "Jingyin-update";
		}
		
		//修改通知
		@RequestMapping("updateJingyin.do")
		public String updateJingyin(Jingyin jingyin){
			jingyinDao.updateJingyin(jingyin);
			return "redirect:Jingyin-management.do";
		}
		
			//去新增页面
		@RequestMapping("Jingyin-insert.do")
		public String gotoinsertJingyin(){
			return "Jingyin-insert";
		}
		
		//添加通知
		@RequestMapping("insertJingyin.do")
		public String insertJingyin(Jingyin jingyin,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			jingyin.setUserid(user.getId());
			jingyinDao.insertJingyin(jingyin);
			return "redirect:Jingyin-management.do";
			}
}


