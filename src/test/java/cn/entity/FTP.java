package cn.entity;

import cn.util.FTPUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class FTP {


    @Test
    public void getId() throws Exception {
        File file = new File("D:\\w.jpg");
        FileInputStream fis = new FileInputStream(file);
        boolean isFtp = FTPUtil.ftpUpload(fis);
        if (isFtp) {
            System.out.println("上传成功");
        }
    }


}