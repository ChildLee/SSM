package cn.util.pay;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * 微信支付工具类
 */
public class PayUtil {
    /**
     * 除去数组中的空值和前后空格
     *
     * @param params 参数集合
     * @return 新的参数集合, 去掉了空值
     */
    public static Map<String, String> paramFilter(Map<String, String> params) {
        Map<String, String> result = new HashMap();
        if (params == null || params.size() <= 0) {
            return result;
        }
        for (String key : params.keySet()) {
            String value = params.get(key);
            if (null == value || "".equals(value.trim())) {
                continue;
            }
            result.put(key, value.trim());
        }
        return result;
    }

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
        String parstr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (null == value || "".equals(value)) {
                continue;
            }
            parstr += "&" + key + "=" + value;
        }
        return parstr.substring(1);
    }

    /**
     * 签名字符串
     *
     * @param linkText 需要签名的字符串
     * @param key      密钥
     * @return 签名结果
     */
    public static String sign(String linkText, String key) {
        String text = linkText + "&key=" + key;
        byte[] bytes = new byte[0];
        try {
            bytes = text.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return DigestUtils.md5DigestAsHex(bytes);
    }


    /**
     * 将参数集合转换成xml格式
     *
     * @param params 参数集合
     * @return xml字符串
     */
    public static String paramsToXML(Map<String, String> params) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("xml");
        for (String key : params.keySet()) {
            root.addElement(key).addCDATA(params.get(key));
        }
        return document.getRootElement().asXML();
    }

    /**
     * 将xml格式转换成参数集合
     *
     * @param xml 需要解析的xml数据
     * @return 参数集合
     */
    public static Map<String, String> xmlToParams(String xml) {
        if (null == xml) {
            return null;
        }
        Map<String, String> result = new HashMap();
        try {
            //读取XML文本内容获取Document对象
            Document document = DocumentHelper.parseText(xml);
            //获取根节点元素对象
            Element root = document.getRootElement();
            //获取当前节点的所有属性节点
            Iterator<Element> iterator = root.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                result.put(element.getName(), element.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 访问微信支付接口发送数据并接受结果
     *
     * @param requestUrl 微信支付接口
     * @param xml        支付数据
     * @return 微信返回的数据
     */
    public static String httpRequest(String requestUrl, String xml) {
        if (null == xml) {
            return null;
        }
        StringBuffer buffer = null;
        try {
            //建立连接
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //往连接的url发送数据
            OutputStream os = conn.getOutputStream();
            os.write(xml.getBytes("utf-8"));
            os.close();
            //读取返回的字节
            InputStream is = conn.getInputStream();
            //字节转字符
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            //字符转文本
            BufferedReader br = new BufferedReader(isr);
            //文本存起来并返回
            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
