package cn.mapper;

import cn.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserInfo(String openId);

    int setUserInfo(User user);
}
