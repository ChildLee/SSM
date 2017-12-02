package cn.mapper;

import cn.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    Admin getAdminAll();
}
