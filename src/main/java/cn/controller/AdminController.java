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

import java.io.IOException;
import java.io.InputStream;

import static cn.util.RandomStringGenerator.getNoFormatTime;
import static cn.util.RandomStringGenerator.getRandomNumber;

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

    @RequestMapping("/fileUpload")
    public void getfileUpload(@RequestParam("files") MultipartFile[] files) {
        try {
            FtpUtil.ftpConnect();
            InputStream is = null;
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getOriginalFilename();
                if (fileName == null || "".equals(fileName)) continue;
                //获取后缀
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                //随机字符串生成,当前时间+随机字符串=文件名
                fileName = getNoFormatTime() + getRandomNumber(5) + suffix;
                //将图片转成流
                is = files[i].getInputStream();
                //上传图片
                FtpUtil.ftpUpload(is, fileName);
            }
            is.close();
            FtpUtil.closeConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
