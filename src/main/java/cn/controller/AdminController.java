package cn.controller;


import cn.entity.Admin;
import cn.service.AdminService;
import cn.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/admin")
    public Admin getAdminAll(String sa) {
        return adminService.getAdminAll();
    }

    @RequestMapping("/fileUpload")
    public Boolean getfileUpload(@RequestParam("files") MultipartFile[] files) {
        if (null == files) return false;
        return FtpUtil.getfileUpload(files);
    }
}
