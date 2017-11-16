package cn.mapper;

import cn.entity.Admin;
import cn.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminMapperTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void getAdminAll() throws Exception {
        Admin ad = adminService.getAdminAll();
        System.out.println(ad.getUser());
    }

}