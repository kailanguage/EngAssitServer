package com.kailang.engasst.controller;

import com.kailang.engasst.common.Const;
import com.kailang.engasst.pojo.User;
import com.kailang.engasst.service.IUserService;
import com.kailang.engasst.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "user/login")
    public ServerResponse login(Integer userno, String password, HttpSession session) {
        ServerResponse serverResponse = userService.loginLogic(userno, password);
        if (serverResponse.isSucess()) {
            session.setAttribute(Const.CURRENT_USER, serverResponse.getData());
        }
        return serverResponse;
    }

    @RequestMapping("user/register")
    public ServerResponse register(Integer userno,String username,String password) {
        User user = new User();
        user.setUserno(userno);
        user.setUname(username);
        user.setUpassword(password);
        return userService.registerLogic(user);
    }

    @RequestMapping("user/logout")
    public ServerResponse logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createServerResponseBySucess();
    }


}
