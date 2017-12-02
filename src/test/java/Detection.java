import cn.aop.Sa;
import cn.dao.CategoryDao;
import cn.entity.Category;
import cn.util.pay.PayParams;
import cn.util.pay.PayUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml", "classpath*:spring-mvc.xml"})
public class Detection {

    @Autowired
    private Sa sa;

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void mb() {
//        String a = "o8Mzw0KOfiA7mO2KB93FLlPnvnbM";
//        System.out.println(a.length());
        List<Category> list = categoryDao.getCategoryLevel(0);
        System.out.println(list);
    }

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
        params = PayUtil.paramFilter(params);
        String xml = PayUtil.paramsToXML(params);
        Map<String, String> map = PayUtil.xmlToParams(xml);
        for (String a : map.keySet()) {
            System.out.println(a);
            System.out.println(map.get(a));
        }
    }

    @Test
    public void da() {

    }

}
