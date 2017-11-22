package cn.entity;

import cn.util.FtpUtil;
import cn.util.RandomStringGenerator;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FTP {


    @Test
    public void getId() throws Exception {
        //获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = df.format(new Date());
        //随机字符串生成,当前时间+随机字符串=文件名
        String fileName = date + RandomStringGenerator.getRandomStringByLength(5);
        FtpUtil.ftpConnect();
        for (int i = 0; i < 10; i++) {
            File file = new File("D:\\w.jpg");
            FileInputStream fis = new FileInputStream(file);
            boolean isFtp = FtpUtil.ftpUpload(fis, fileName + ".jpg");
            FtpUtil.ftpDelete(fileName + ".jpg");
            if (isFtp) {
                System.out.println("上传成功" + i);
            }
            fis.close();
        }
        FtpUtil.closeConnect();
    }

    @Test
    public void a() {
        System.out.println(FtpUtil.ftpDelete(""));
    }
}