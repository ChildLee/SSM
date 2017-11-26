package cn.util.pay;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PayUtil {

    /**
     * 对参数按照key=value的格式，并按照参数名ASCII字典序排序
     *
     * @param params 参数集合
     * @return 拼接完返回字符串
     */
    public static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        //微信要求按照参数名ASCII字典序排序
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            prestr += "&" + key + "=" + value;
        }
        return prestr.substring(1);
    }

    /**
     * 签名字符串
     *
     * @param linkText 需要签名的字符串
     * @param key      密钥
     * @return 签名结果
     */
    public static String sign(String linkText, String key) {
        String text = linkText + key;
        byte[] bytes = new byte[0];
        try {
            bytes = text.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return DigestUtils.md5DigestAsHex(bytes);
    }
}
