package cn.util.pay;

import java.util.HashMap;
import java.util.Map;

public class Payment {


    public void pay() {
        PayParams payParams = new PayParams();

        Map<String, String> params = new HashMap<String, String>();
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

        //对参数按照key=value的格式，并按照参数名ASCII字典序排序
        String prestr = PayUtil.createLinkString(null);
        //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
        String mysign = PayUtil.sign(prestr, "").toUpperCase();
    }
}
