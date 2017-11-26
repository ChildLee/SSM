package cn.util.pay;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 微信支付
 */
public class Payment {
    //统一下单接口
    private static final String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //读取配置文件
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("wxPay");
    //读取配置文件参数
    private static final String appid = resourceBundle.getString("appid");
    private static final String appSecret = resourceBundle.getString("appSecret");
    private static final String mch_id = resourceBundle.getString("mch_id");
    private static final String key = resourceBundle.getString("key");

    public void pay() {
        PayParams payParams = new PayParams();

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
        //
        String a = PayUtil.httpRequest(url, xml);
    }
}
