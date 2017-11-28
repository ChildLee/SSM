package cn.action;


import cn.entity.Admin;
import cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AdminAction {

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/admin")
    public Admin getAdminAll() {
        return adminService.getAdminAll();
    }


}
