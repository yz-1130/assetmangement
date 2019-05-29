package com.cn.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.domain.Licai;
import com.cn.service.LicaiDao;
@Controller
	public class LicaiController {
	@Autowired
		LicaiDao   licaiDao;
	//goto management page
	@RequestMapping("Licai-management.do")
	public String gotoLicai(Model model,HttpServletRequest req){
		Licai licai=new Licai();
		HttpSession session = req.getSession(true);  
		User user=(User) session.getAttribute("user");
		if(!"管理员".equalsIgnoreCase(user.getRole())){
			licai.setUserid(user.getId());
		}
		List<Licai> qlist=licaiDao.selectLicai(licai);
		int sum = 0;
		for (Licai licai1 : qlist) {
			int jine;
			jine = licai1.getJine();
			sum += jine;
		}
		int totalAssetsAmount = sum;
		model.addAttribute("totalAssetsAmount", totalAssetsAmount);
		model.addAttribute("result", qlist);
		return "Licai-management";
}

		//查询
		@RequestMapping("selectLicai.do")
		public String selectLicai(Licai licai,Model model,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			if(!"管理员".equalsIgnoreCase(user.getRole())){
			licai.setUserid(user.getId());
			}
			List<Licai> qlist=licaiDao.selectLicai(licai);
			model.addAttribute("result", qlist);
			return "Licai-management";
		}
		
		//删除通知
		@RequestMapping("deleteLicai.do")
		public String deleteLicai(Licai licai){
			licaiDao.deleteLicai(licai);
		return "redirect:Licai-management.do";
		}
		
		//进入更新通知的页面
		@RequestMapping("gotoUpdateLicai.do")
		public String gotoUpdateLicai(Licai licai,Model model){
			List<Licai> a=licaiDao.selectLicai(licai);
			model.addAttribute("result",a);
			return "Licai-update";
		}
		
		//修改通知
		@RequestMapping("updateLicai.do")
		public String updateLicai(Licai licai){
			licaiDao.updateLicai(licai);
			return "redirect:Licai-management.do";
		}
		
			//去新增页面
		@RequestMapping("Licai-insert.do")
		public String gotoinsertLicai(){
			return "Licai-insert";
		}
		
		//添加通知
		@RequestMapping("insertLicai.do")
		public String insertLicai(Licai licai,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			licai.setUserid(user.getId());
			licaiDao.insertLicai(licai);
			return "redirect:Licai-management.do";
			}
}


