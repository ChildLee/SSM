package cn.service.Impl;

import cn.dao.UserDao;
import cn.entity.User;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserInfo(String openId) {
        return userDao.getUserInfo(openId);
    }

    @Override
    public int setUserInfo(User user) {
        User userInfo = userDao.getUserInfo(user.getOpenid());
        if (null == userInfo) {
            int result = userDao.setUserInfo(user);
            if (result > 0) {
                userInfo = userDao.getUserInfo(user.getOpenid());
            }
        }
        return userInfo.getId();
    }
}
