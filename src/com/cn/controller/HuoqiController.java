package com.cn.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.domain.Huoqi;
import com.cn.service.HuoqiDao;
@Controller
	public class HuoqiController {
	@Autowired
		HuoqiDao   HuoqiDao;
	//goto management page
	@RequestMapping("Huoqi-management.do")
	public String gotoHuoqi(Model model,HttpServletRequest req){
		Huoqi Huoqi=new Huoqi();
		HttpSession session = req.getSession(true);  
		User user=(User) session.getAttribute("user");
		if(!"管理员".equalsIgnoreCase(user.getRole())){
			Huoqi.setUserid(user.getId());
		}
		List<Huoqi> qlist=HuoqiDao.selectHuoqi(Huoqi);
		model.addAttribute("result", qlist);
		return "Huoqi-management";
}

		//查询
		@RequestMapping("selectHuoqi.do")
		public String selectHuoqi(Huoqi Huoqi,Model model,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			if(!"管理员".equalsIgnoreCase(user.getRole())){
			Huoqi.setUserid(user.getId());
			}
			List<Huoqi> qlist=HuoqiDao.selectHuoqi(Huoqi);
			model.addAttribute("result", qlist);
			return "Huoqi-management";
		}
		
		//删除通知
		@RequestMapping("deleteHuoqi.do")
		public String deleteHuoqi(Huoqi Huoqi){
			HuoqiDao.deleteHuoqi(Huoqi);
		return "redirect:Huoqi-management.do";
		}
		
		//进入更新通知的页面
		@RequestMapping("gotoUpdateHuoqi.do")
		public String gotoUpdateHuoqi(Huoqi Huoqi,Model model){
			List<Huoqi> a=HuoqiDao.selectHuoqi(Huoqi);
			model.addAttribute("result",a);
			return "Huoqi-update";
		}
		
		//修改通知
		@RequestMapping("updateHuoqi.do")
		public String updateHuoqi(Huoqi Huoqi){
			HuoqiDao.updateHuoqi(Huoqi);
			return "redirect:Huoqi-management.do";
		}
		
			//去新增页面
		@RequestMapping("Huoqi-insert.do")
		public String gotoinsertHuoqi(){
			return "Huoqi-insert";
		}
		
		//添加通知
		@RequestMapping("insertHuoqi.do")
		public String insertHuoqi(Huoqi Huoqi,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			Huoqi.setUserid(user.getId());
			HuoqiDao.insertHuoqi(Huoqi);
			return "redirect:Huoqi-management.do";
			}
}


