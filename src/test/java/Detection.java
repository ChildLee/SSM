import cn.aop.Sa;
import cn.util.RandomStringGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        String a = RandomStringGenerator.getNoFormatTimeOut(60);
        System.out.println(a);
    }
}
