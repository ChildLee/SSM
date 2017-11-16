package cn.controller;

import cn.entity.Admin;
import cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/admin")
    public String getAdminAll(String sa) {
        Admin ad = adminService.getAdminAll();
        return ad.getUser();
    }
}
