package cn.controller;

import cn.entity.Admin;
import cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin")
    public ModelAndView getAdminAll() {
        Admin ad = adminService.getAdminAll();
        System.out.println(ad.getUser());
        ModelAndView mav = new ModelAndView("add");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }
}
