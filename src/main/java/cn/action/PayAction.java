package cn.action;

import cn.util.pay.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PayAction {

    @ResponseBody
    @RequestMapping(value = "/getOpenId", method = RequestMethod.POST)
    public String getOpenId(String code) {
        if (null == code || "".equals(code)) return null;
        return Payment.getOpenId(code);
    }
}
