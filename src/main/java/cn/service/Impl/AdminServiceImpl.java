package cn.service.Impl;

import cn.entity.Admin;
import cn.mapper.AdminMapper;
import cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminAll() {
        return adminMapper.getAdminAll();
    }
}
