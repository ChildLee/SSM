package cn.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

public class FtpUtil {
    //读取配置文件
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("ftp");
    //读取配置信息
    private static final String url = resourceBundle.getString("ftp.url");
    private static final int port = Integer.parseInt(resourceBundle.getString("ftp.port"));
    private static final String username = resourceBundle.getString("ftp.username");
    private static final String password = resourceBundle.getString("ftp.password");
    private static final String path = resourceBundle.getString("ftp.path");
    //ftp实例
    private static FTPClient ftpClient;
    //log4j
    private static Logger logger = LogManager.getLogger("log");

    /**
     * 建立ftp连接
     *
     * @return 是否连接成功
     */
    public static boolean ftpConnect() {
        //实例化一个ftp客户端
        ftpClient = new FTPClient();
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
                logger.info("FTP连接失败");
                //连接失败时断开连接
                ftpClient.disconnect();
                //返回false
                return false;
            }
            //设置ftp连接目录
            if (!DirectoryExist()) {
                return false;
            }
            //设置文件编码格式
            //ftpClient.setControlEncoding("GBK");
            //设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        } catch (IOException e) {
            logger.error("ftp连接错误");
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 设置ftp连接目录
     *
     * @return 目录是否连接成功
     */
    private static Boolean DirectoryExist() {
        Boolean DirectoryExist = null;
        try {
            DirectoryExist = ftpClient.changeWorkingDirectory(path);
            if (!DirectoryExist) {
                //如果目录不存在创建目录
                String[] dirs = path.split("/");
                String Path = "";
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    Path += "/" + dir;
                    //判断目录存在为false,并切换为该目录
                    if (!ftpClient.changeWorkingDirectory(Path)) {
                        //目录不存在则创建目录,创建失败则方法结束
                        if (!ftpClient.makeDirectory(Path)) {
                            return false;
                        }
                    }
                }
                //目录创建成功,切换到该目录
                ftpClient.changeWorkingDirectory(Path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 退出并关闭FTP连接
     */
    public static void closeConnect() {
        try {
            //判断是否还连接
            if (ftpClient != null && ftpClient.isConnected()) {
                //退出登录
                ftpClient.logout();
                //关闭ftp连接
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ftp文件上传
     *
     * @param fileName 上传的文件名
     * @param is       上传的文件
     * @return 是否上传成功
     */
    public static boolean ftpUpload(String fileName, InputStream is) {
        return ftpUpload(is, fileName);
    }

    /**
     * ftp文件上传
     *
     * @param is       上传的文件
     * @param fileName 上传的文件名
     * @return 是否上传成功
     */
    public static boolean ftpUpload(InputStream is, String fileName) {
        Boolean success = false;
        try {
            //上传文件
            success = ftpClient.storeFile(fileName, is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }

    /**
     * ftp文件删除
     *
     * @param fileName 删除的文件名
     * @return 是否删除成功
     */
    public static boolean ftpDelete(String fileName) {
        if (fileName == null || "".equals(fileName)) {
            return false;
        }
        boolean success = false;
        //删除文件
        try {
            success = ftpClient.deleteFile(new String(fileName.getBytes("GBK"), "ISO-8859-1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }

}