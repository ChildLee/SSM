package cn.controller;

import cn.entity.User;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserAction {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/setUserInfo", method = RequestMethod.POST)
    public int setUserInfo(User user) {
        if (null == user) return -1;
        return userService.setUserInfo(user);
    }
}
