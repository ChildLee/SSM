package cn.util.pay;

import cn.util.RandomStringGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 微信支付入口
 */
public class Payment {
    //统一下单接口
    private static final String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //读取配置文件
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("wxPay");
    //读取配置文件参数
    private static final String appid = resourceBundle.getString("appid");
    private static final String mch_id = resourceBundle.getString("mch_id");
    private static final String key = resourceBundle.getString("key");

    /**
     * 微信支付入口
     */
    public static Map<String, String> pay(PayParams payParams) {
        payParams.setAppid(appid);
        payParams.setMch_id(mch_id);
        payParams.setDevice_info("");
        payParams.setNonce_str(RandomStringGenerator.getRandomString(30).toUpperCase());
        payParams.setSign("");
        payParams.setBody("");
        payParams.setDetail("");
        payParams.setAttach("");
        payParams.setOut_trade_no("");
        payParams.setFee_type("");
        payParams.setSpbill_create_ip("");
        payParams.setTime_start("");
        payParams.setTime_expire("");
        payParams.setGoods_tag("");
        payParams.setTotal_fee("");
        payParams.setNotify_url("");
        payParams.setTrade_type("");
        payParams.setLimit_pay("");
        payParams.setOpenid("");

        Map<String, String> params = new HashMap();
        params.put("appid", payParams.getAppid());
        params.put("mch_id", payParams.getMch_id());
        params.put("nonce_str", payParams.getNonce_str());
        params.put("body", payParams.getBody());
        params.put("out_trade_no", payParams.getOut_trade_no());
        params.put("total_fee", payParams.getTotal_fee());
        params.put("spbill_create_ip", payParams.getSpbill_create_ip());
        params.put("notify_url", payParams.getNotify_url());
        params.put("trade_type", payParams.getTrade_type());
        params.put("openid", payParams.getOpenid());
        //除去数组中的空值和前后空格
        params = PayUtil.paramFilter(params);
        //对参数按照key=value的格式，并按照参数名ASCII字典序排序
        String parstr = PayUtil.createLinkString(params);
        //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
        String sign = PayUtil.sign(parstr, key).toUpperCase();
        //将签名后的字符串放入集合
        params.put("sign", sign);
        //参数转换成xml格式
        String xml = PayUtil.paramsToXML(params);
        //访问微信支付接口发送数据并接受结果
        String result = PayUtil.httpRequest(url, xml);
        //将获取的xml格式结果转换成map键值对
        Map<String, String> mapResult = PayUtil.xmlToParams(result);
        //返回状态码,成功为"SUCCESS"
        String return_code = mapResult.get("return_code");
        //返回给小程序端需要的参数
        Map<String, String> response = new HashMap();
        //判断是否成功
        if (return_code == "SUCCESS" || "SUCCESS".equals(return_code)) {
            //返回的预付单信息
            String prepay_id = mapResult.get("prepay_id");
            //需要返回的参数添加到集合
            response.put("appId", payParams.getAppid());
            response.put("nonceStr", payParams.getNonce_str());
            response.put("package", "prepay_id=" + prepay_id);
            response.put("timeStamp", RandomStringGenerator.getTimeStamp());
            response.put("signType", "MD5");
            //转换成键值对字符串进行签名
            String strSign = PayUtil.createLinkString(response);
            String paySign = PayUtil.sign(strSign, key).toUpperCase();
            //将签名添加到返回的集合
            response.put("paySign", paySign);
        }
        return response;
    }
}
