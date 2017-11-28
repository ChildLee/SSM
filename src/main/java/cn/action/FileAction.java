package cn.action;

import cn.util.FtpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileAction {
    @RequestMapping("/fileUpload")
    public Boolean getfileUpload(@RequestParam("files") MultipartFile[] files) {
        if (null == files) return false;
        return FtpUtil.getfileUpload(files);
    }
}
