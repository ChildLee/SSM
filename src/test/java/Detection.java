import cn.aop.Sa;
import cn.util.pay.PayParams;
import cn.util.pay.PayUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml", "classpath*:spring-mvc.xml"})
public class Detection {

    @Autowired
    private Sa sa;

    @Test
    public void ftpTest() throws Exception {
        sa.wo();
    }

    @Test
    public void MD5Test() {
        PayParams payParams = new PayParams();

        Map<String, String> params = new HashMap();
        params.put("appid", "123");
        params.put("mch_id", "123");
        params.put("nonce_str", "123");
        params.put("body", "666");
        params.put("out_trade_no", "123");
        params.put("total_fee", "123");
        params.put("spbill_create_ip", "123");
        params.put("notify_url", "123");
        params.put("trade_type", "123");
        params.put("openid", "123");
        //除去数组中的空值和前后空格
        params = PayUtil.paramFilter(params);
        //对参数按照key=value的格式，并按照参数名ASCII字典序排序
        String parstr = PayUtil.createLinkString(params);
        //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
        String mysign = PayUtil.sign(parstr, "123key").toUpperCase();
        System.out.println(parstr);
    }
}
