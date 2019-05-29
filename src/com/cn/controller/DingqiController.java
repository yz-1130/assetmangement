package com.cn.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.domain.Dingqi;
import com.cn.service.DingqiDao;

@Controller
	public class DingqiController {
	@Autowired
		DingqiDao   dingqiDao;
	//goto management page
	@RequestMapping("Dingqi-management.do")
	public String gotoDingqi(Model model,HttpServletRequest req){
		//ModelAndView view = new ModelAndView("/Dingqi-management");
		Dingqi dingqi=new Dingqi();
		HttpSession session = req.getSession(true);  
		User user=(User) session.getAttribute("user");
		if(!"管理员".equalsIgnoreCase(user.getRole())){
			dingqi.setUserid(user.getId());
		}

		List<Dingqi> qlist=dingqiDao.selectDingqi(dingqi);
		int sum = 0;
		for (Dingqi dingqi1 : qlist) {
			int jine = dingqi1.getJine();
			sum += jine;
		}
		Integer totalAssetsAmount = sum;
		model.addAttribute("totalAssetsAmount", totalAssetsAmount);
		model.addAttribute("result", qlist);

		return "Dingqi-management";
}

		//查询
		@RequestMapping("selectDingqi.do")
		public String selectDingqi(Dingqi dingqi,Model model,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			if(!"管理员".equalsIgnoreCase(user.getRole())){
			dingqi.setUserid(user.getId());
			}
			List<Dingqi> qlist=dingqiDao.selectDingqi(dingqi);
			model.addAttribute("result", qlist);
			return "Dingqi-management";
		}
		
		//删除通知
		@RequestMapping("deleteDingqi.do")
		public String deleteDingqi(Dingqi dingqi){
			dingqiDao.deleteDingqi(dingqi);
		return "redirect:Dingqi-management.do";
		}
		
		//进入更新通知的页面
		@RequestMapping("gotoUpdateDingqi.do")
		public String gotoUpdateDingqi(Dingqi dingqi,Model model){
			List<Dingqi> a=dingqiDao.selectDingqi(dingqi);
			model.addAttribute("result",a);
			return "Dingqi-update";
		}
		
		//修改通知
		@RequestMapping("updateDingqi.do")
		public String updateDingqi(Dingqi dingqi){
			dingqiDao.updateDingqi(dingqi);
			return "redirect:Dingqi-management.do";
		}
		
			//去新增页面
		@RequestMapping("Dingqi-insert.do")
		public String gotoinsertDingqi(){
			return "Dingqi-insert";
		}
		
		//添加通知
		@RequestMapping("insertDingqi.do")
		public String insertDingqi(Dingqi dingqi,HttpServletRequest req){
			HttpSession session = req.getSession(true);  
			User user=(User) session.getAttribute("user");
			dingqi.setUserid(user.getId());
			dingqiDao.insertDingqi(dingqi);
			return "redirect:Dingqi-management.do";
			}
}


