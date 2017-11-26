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
        //注释的参数为前端传入,部分参数可以不填
        payParams.setAppid(appid);
        payParams.setMch_id(mch_id);
        //payParams.setDevice_info("");//终端设备号(门店号或收银设备ID)
        payParams.setNonce_str(RandomStringGenerator.getRandomString(32).toUpperCase());//随机字符串
        //payParams.setSign("");//签名
        payParams.setSign_type("MD5");//签名类型
        //payParams.setBody("");//商品描述
        //payParams.setDetail("");//商品详情
        //payParams.setAttach("");//附加数据
        payParams.setOut_trade_no(RandomStringGenerator.getNoFormatTime()
                + RandomStringGenerator.getRandomNumber(18));//商户订单号
        payParams.setFee_type("CNY");//货币类型
        //payParams.setTotal_fee("");//总金额
        //payParams.setSpbill_create_ip("");//终端IP
        payParams.setTime_start(RandomStringGenerator.getNoFormatTime());//交易起始时间
        payParams.setTime_expire(RandomStringGenerator.getNoFormatTimeOut(1440));//交易结束时间
        //payParams.setGoods_tag("");//商品标记
        //payParams.setNotify_url("");//通知地址
        payParams.setTrade_type("JSAPI");//交易类型
        //payParams.setLimit_pay("");//指定支付方式
        //payParams.setOpenid("");//用户标识

        //所有参数全部放到集合里面去,空值下面会处理
        Map<String, String> params = new HashMap();
        params.put("appid", payParams.getAppid());
        params.put("mch_id", payParams.getMch_id());
        params.put("device_info", payParams.getDevice_info());
        params.put("nonce_str", payParams.getNonce_str());
        //params.put("sign", payParams.getSign());
        params.put("sign_type", payParams.getSign_type());
        params.put("body", payParams.getBody());
        params.put("detail", payParams.getDetail());
        params.put("attach", payParams.getAttach());
        params.put("out_trade_no", payParams.getOut_trade_no());
        params.put("fee_type", payParams.getFee_type());
        params.put("total_fee", payParams.getTotal_fee());
        params.put("spbill_create_ip", payParams.getSpbill_create_ip());
        params.put("time_start", payParams.getTime_start());
        params.put("time_expire", payParams.getTime_expire());
        params.put("goods_tag", payParams.getGoods_tag());
        params.put("notify_url", payParams.getNotify_url());
        params.put("trade_type", payParams.getTrade_type());
        params.put("limit_pay", payParams.getLimit_pay());
        params.put("openid", payParams.getOpenid());
        //除去集合中的空值和前后空格
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
            response.put("signType", payParams.getSign_type());
            //转换成键值对字符串进行签名
            String strSign = PayUtil.createLinkString(response);
            String paySign = PayUtil.sign(strSign, key).toUpperCase();
            //将签名添加到返回的集合
            response.put("paySign", paySign);
        }

        return response;
    }
}
