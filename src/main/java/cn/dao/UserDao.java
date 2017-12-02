package cn.dao;

import cn.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserInfo(String openId);

    int setUserInfo(User user);
}
