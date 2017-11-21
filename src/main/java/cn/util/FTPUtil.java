package cn.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class FTPUtil {
    //读取配置文件
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("ftp");
    //读取配置信息
    private static final String url = resourceBundle.getString("ftp.url");
    private static final int port = Integer.parseInt(resourceBundle.getString("ftp.port"));
    private static final String username = resourceBundle.getString("ftp.username");
    private static final String password = resourceBundle.getString("ftp.password");
    private static final String path = resourceBundle.getString("ftp.path");

    /**
     * 文件上传
     *
     * @param fis 文件流
     * @return 返回boolean结果，判断是否上传成功
     */
    public static boolean ftpUpload(FileInputStream fis) {
        boolean success = false;
        //实例化一个ftp客户端
        FTPClient ftpClient = new FTPClient();
        try {
            //建立ftp连接
            ftpClient.connect(url, port);
            //输入ftp账号密码
            ftpClient.login(username, password);
            //主动模式
            //ftpClient.enterLocalActiveMode();
            //被动模式
            ftpClient.enterLocalPassiveMode();
            // 看返回的值是不是230，如果是，表示登陆成功
            int reply = ftpClient.getReplyCode();
            //判断是否连接成功
            if (!FTPReply.isPositiveCompletion(reply)) {
                //连接失败时断开连接
                ftpClient.disconnect();
                //返回false
                return success;
            }
            //设置上传目录
            Boolean isDirectory = ftpClient.changeWorkingDirectory(path);
            if (!isDirectory) {
                //如果目录不存在创建目录
                String[] dirs = path.split("/");
                String Path = "";
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    Path += "/" + dir;
                    //判断目录存在为false,并切换为该目录
                    if (!ftpClient.changeWorkingDirectory(Path)) {
                        //目录不存在则创建目录,创建失败则方法结束
                        if (ftpClient.makeDirectory(Path)) {
                            //目录创建成功,切换到该目录
                            ftpClient.changeWorkingDirectory(Path);
                        } else {
                            //退出登录
                            ftpClient.logout();
                            //判断是否还连接
                            if (ftpClient.isConnected()) {
                                //关闭ftp连接
                                ftpClient.disconnect();
                            }
                            return success;
                        }
                    }
                }
                System.out.println(Path);
            }
            //设置文件编码格式
            ftpClient.setControlEncoding("GBK");
            //设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

            //获取系统当前时间
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = df.format(new Date());
            //随机字符串还没生成,时间+随机字符串=文件名
            String fileName = date + RandomStringGenerator.getRandomStringByLength(18);

            //上传文件流
            ftpClient.storeFile(fileName + ".jpg", fis);

            //关闭流
            fis.close();
            //退出登录
            ftpClient.logout();
            //文件上传结束,返回结果设置为true
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //判断是否还连接
            if (ftpClient.isConnected()) {
                try {
                    //关闭ftp连接
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //返回true
        return success;
    }
}
