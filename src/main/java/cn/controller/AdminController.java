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
import static cn.util.Util.ImgCompression;

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
            //连接FTP
            if (!FtpUtil.ftpConnect()) return;
            InputStream is = null;
            for (int i = 0; i < files.length; i++) {
                //获取上传的文件名
                String fileName = files[i].getOriginalFilename();
                //判断上传的文件是否为空
                if (fileName == null || "".equals(fileName)) continue;
                //获取文件后缀
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                //随机字符串生成,当前时间+随机字符串=文件名
                fileName = getNoFormatTime() + getRandomNumber(8) + suffix;
                //将文件转成流
                is = files[i].getInputStream();
                //图片压缩
                is = ImgCompression(is, suffix.substring(1));
                //上传图片
                FtpUtil.ftpUpload(is, fileName);
            }
            //关闭流
            is.close();
            //关闭FTP连接
            FtpUtil.closeConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
