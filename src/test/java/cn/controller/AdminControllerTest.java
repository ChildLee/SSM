package cn.controller;

import cn.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminControllerTest {

    @Autowired
    private AdminController adminController;

    @Test
    public void getAdminAll() throws Exception {
        Admin ad = adminController.getAdminAll();
        System.out.println(ad.getUser());
    }

}