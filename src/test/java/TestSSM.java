import cn.entity.Admin;
import cn.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
public class TestSSM {

    private AdminService adminService;

    @Test
    public void mbts() throws Exception {
        Admin ad = adminService.getAdminAll();
        System.out.println(ad);
    }
}