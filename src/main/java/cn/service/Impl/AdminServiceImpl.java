package cn.service.Impl;

import cn.dao.AdminDao;
import cn.entity.Admin;
import cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin getAdminAll() {
        return adminDao.getAdminAll();
    }
}
