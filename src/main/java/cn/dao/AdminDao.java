package cn.dao;

import cn.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    Admin getAdminAll();
}
