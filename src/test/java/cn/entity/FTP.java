package cn.entity;

import cn.util.FtpUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class FTP {


    @Test
    public void getId() throws Exception {
        File file = new File("D:\\w.jpg");
        FileInputStream fis = new FileInputStream(file);
        boolean isFtp = FtpUtil.ftpUpload(fis);
        if (isFtp) {
            System.out.println("上传成功");
        }
    }


}