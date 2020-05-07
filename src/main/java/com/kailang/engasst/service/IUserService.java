package com.kailang.engasst.service;

import com.kailang.engasst.pojo.User;
import com.kailang.engasst.utils.ServerResponse;

public interface IUserService {

    /**
     * 登录
     * */
     ServerResponse loginLogic(Integer userno, String password);

    /**
     * 注册
     * */

     ServerResponse registerLogic(User user);

}
