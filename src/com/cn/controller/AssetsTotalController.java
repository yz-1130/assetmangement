package com.cn.controller;
import com.cn.domain.AssetsTotal;
import com.cn.domain.Baoxian;
import com.cn.service.AssetsTotalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import com.cn.domain.User;

@Controller
public class AssetsTotalController {
    @Autowired
    AssetsTotalDao assetsTotalDao;
    @RequestMapping("AssetsTotal-management.do")
    public String gotoAssetsTotal(Model model, HttpServletRequest req){
        AssetsTotal assetsTotal=new AssetsTotal();
        HttpSession session = req.getSession(true);
        User user=(User) session.getAttribute("user");
        if(!"管理员".equalsIgnoreCase(user.getRole())){
            assetsTotal.setUserid(user.getId());
        }
        List<AssetsTotal> qlist=assetsTotalDao.selectAssetsTotal(assetsTotal);
        model.addAttribute("result", qlist);
        return "AssetsTotal-management";
    }

    //查询
    @RequestMapping("selectAssetsTotal.do")
    public String selectAssetsTotal(AssetsTotal assetsTotal, Model model, HttpServletRequest req){
        HttpSession session = req.getSession(true);
        User user=(User) session.getAttribute("user");
        if(!"管理员".equalsIgnoreCase(user.getRole())){
            assetsTotal.setUserid(user.getId());
        }
        List<AssetsTotal> qlist=assetsTotalDao.selectAssetsTotal(assetsTotal);
        model.addAttribute("result", qlist);
        return "AssetsTotal-management";
    }

    //删除通知
    @RequestMapping("deleteAssetsTotal.do")
    public String deleteAssetsTotal(AssetsTotal assetsTotal){
        assetsTotalDao.deleteAssetsTotal(assetsTotal);
        return "redirect:AssetsTotal-management.do";
    }



    //进入更新通知的页面
    @RequestMapping("gotoUpdateAssetsTotal.do")
    public String gotoUpdateAssetsTotal(AssetsTotal assetsTotal,Model model){
        List<AssetsTotal> a=assetsTotalDao.selectAssetsTotal(assetsTotal);
        model.addAttribute("result",a);
        return "AssetsTotal-update";
    }

    //去新增页面
    @RequestMapping("AssetsTotal-insert.do")
    public String gotoinsertAssetsTotal(){
        return "AssetsTotal-insert";
    }
    //修改通知
    @RequestMapping("updateAssetsTotal.do")
    public String updateAssetsTotal(AssetsTotal assetsTotal){
        assetsTotalDao.updateAssetsTotal(assetsTotal);
        return "redirect:AssetsTotal-management.do";
    }


    //添加通知
    @RequestMapping("insertAssetsTotal.do")
    public String insertAssetsTotal(AssetsTotal assetsTotal, HttpServletRequest req){
        HttpSession session = req.getSession(true);
        User user=(User) session.getAttribute("user");
        assetsTotal.setUserid(user.getId());
        assetsTotalDao.insertAssetsTotal(assetsTotal);
        return "redirect:AssetsTotal-management.do";
    }
}



