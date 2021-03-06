package cn.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 随机字符串生成
 */
public class RandomStringGenerator {

    /**
     * 获取一定长度的随机字符串
     *
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }

    /**
     * 获取一定长度的随机数字
     *
     * @param length 指定数字长度
     * @return 一定长度的数字
     */
    public static String getRandomNumber(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }

    /**
     * 获取无分隔的系统时间
     *
     * @return 无分隔格式的系统时间字符串
     */
    public static String getNoFormatTime() {
        //获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }

    /**
     * 获取时间戳,精确到秒
     *
     * @return 时间戳字符串
     */
    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    /**
     * 获取当前时间往后多少分钟的时间
     *
     * @param minute 分钟
     * @return 当前时间往后延迟的时间
     */
    public static String getNoFormatTimeOut(int minute) {
        //获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date().getTime() + (minute * 60 * 1000));
    }
}
