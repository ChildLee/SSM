package cn.service;

import cn.entity.User;

public interface UserService {
    /**
     * 获取用户信息
     */
    User getUserInfo(String openId);

    /**
     * 保存用户信息,名称,图像,openid
     *
     * @param user 用户信息
     */
    int setUserInfo(User user);
}
