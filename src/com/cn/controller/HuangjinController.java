package com.cn.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.domain.Huangjin;
import com.cn.service.HuangjinDao;
@Controller
	public class HuangjinController {
	@Autowired
		HuangjinDao   huangjinDao;
	//goto management page
	@RequestMapping("Huangjin-management.do")
	public String gotoHuangjin(Model model,HttpServletRequest req){
		Huangjin huangjin=new Huangjin();
		HttpSession session = req.getSession(true);  
		User user=(User) session.getAttribute("user");
		if(!"管理员".equalsIgnoreCase(user.getRole())){
			huangjin.setUserid(user.getId());
		}
		List<Huangjin> qlist=huangjinDao.selectHuangjin(huangjin);
		int sum = 0;
		for (Huangjin huangjin1 : qlist) {
			int jine;
			jine = huangjin1.getJine();
			sum += jine;
		}
		int totalAssetsAmount = sum;
		model.addAttribute("totalAssetsAmount", totalAssetsAmount);
		model.addAttribute("result", qlist);
		return "Huangjin-management";
}

		//查询
		@RequestMapping("selectHuangjin.do")
		public String selectHuangjin(Huangjin huangjin,Model model,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			if(!"管理员".equalsIgnoreCase(user.getRole())){
			huangjin.setUserid(user.getId());
			}
			List<Huangjin> qlist=huangjinDao.selectHuangjin(huangjin);
			model.addAttribute("result", qlist);
			return "Huangjin-management";
		}
		
		//删除通知
		@RequestMapping("deleteHuangjin.do")
		public String deleteHuangjin(Huangjin huangjin){
			huangjinDao.deleteHuangjin(huangjin);
		return "redirect:Huangjin-management.do";
		}
		
		//进入更新通知的页面
		@RequestMapping("gotoUpdateHuangjin.do")
		public String gotoUpdateHuangjin(Huangjin huangjin,Model model){
			List<Huangjin> a=huangjinDao.selectHuangjin(huangjin);
			model.addAttribute("result",a);
			return "Huangjin-update";
		}
		
		//修改通知
		@RequestMapping("updateHuangjin.do")
		public String updateHuangjin(Huangjin huangjin){
			huangjinDao.updateHuangjin(huangjin);
			return "redirect:Huangjin-management.do";
		}
		
			//去新增页面
		@RequestMapping("Huangjin-insert.do")
		public String gotoinsertHuangjin(){
			return "Huangjin-insert";
		}
		
		//添加通知
		@RequestMapping("insertHuangjin.do")
		public String insertHuangjin(Huangjin huangjin,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			huangjin.setUserid(user.getId());
			huangjinDao.insertHuangjin(huangjin);
			return "redirect:Huangjin-management.do";
			}
}


