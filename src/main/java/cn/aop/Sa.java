package cn.aop;

import org.springframework.stereotype.Component;

@Component
public class Sa {
    public void wo() throws Exception {
        System.out.println("怎么了");
        throw new Exception("手动抛出一个异常");
    }
}
