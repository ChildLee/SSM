package cn.service.Impl;

import cn.entity.User;
import cn.mapper.UserMapper;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String openId) {
        return userMapper.getUserInfo(openId);
    }

    @Override
    public int setUserInfo(User user) {
        User userInfo = userMapper.getUserInfo(user.getOpenid());
        if (null == userInfo) {
            int result = userMapper.setUserInfo(user);
            if (result > 0) {
                userInfo = userMapper.getUserInfo(user.getOpenid());
            }
        }
        return userInfo.getId();
    }
}
