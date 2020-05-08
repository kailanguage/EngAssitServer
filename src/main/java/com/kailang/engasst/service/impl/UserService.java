package com.kailang.engasst.service.impl;

import com.kailang.engasst.common.ResponseCode;
import com.kailang.engasst.dao.UserMapper;
import com.kailang.engasst.pojo.User;
import com.kailang.engasst.service.IUserService;
import com.kailang.engasst.utils.ServerResponse;
import com.kailang.engasst.utils.StringUtil;
import com.kailang.engasst.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse loginLogic(Integer userno, String password) {

        //1: 用户名和密码的非空判断

        if (StringUtil.isBlank(userno.toString())) {
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(), ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtil.isBlank(password)) {
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(), ResponseCode.PASSWORD_NOT_EMPTY.getMsg());
        }
        //2:查看用户名是否存在
        Integer count = userMapper.findByUsername(userno);
        if (count == 0) {
            //用户名不存在
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EXISTS.getCode(), ResponseCode.USERNAME_NOT_EXISTS.getMsg());
        }

        //3: 根据用户名和密码查询
        User user = userMapper.findByUsernameAndPassword(userno, password);

        if (user == null) {
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_ERROR.getCode(), ResponseCode.PASSWORD_ERROR.getMsg());
        }

        //step4:返回结果
        return ServerResponse.createServerResponseBySucess(convert(user));
    }

    private UserVO convert(User user) {
        UserVO userVO = new UserVO();
        userVO.setUserno(user.getUserno());
        userVO.setUname(user.getUname());
        userVO.setUpassword(user.getUpassword());
        return userVO;
    }

    @Override
    public ServerResponse registerLogic(User user) {

        if (user == null) {
            return ServerResponse.createServerResponseByFail(ResponseCode.PARAMTER_NOT_EMPTY.getCode(), ResponseCode.PARAMTER_NOT_EMPTY.getMsg());
        }
        Integer userno = user.getUserno();
        String username = user.getUname();
        String password = user.getUpassword();
        //用户ID、用户名、密码不能为空
        if (userno == null || userno.equals("")||StringUtil.isBlank(userno.toString())){
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNO_ILLEGAL.getCode(), ResponseCode.USERNO_ILLEGAL.getMsg());
        }
        if (username == null || username.equals("")||StringUtil.isBlank(username)) {
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(), ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if (password == null || password.equals("")||StringUtil.isBlank(password)) {
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(), ResponseCode.PASSWORD_NOT_EMPTY.getMsg());
        }

        //判断用户名是否存在
        Integer count = userMapper.findByUsername(userno);
        if (count > 0) {//用户名存在
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_EXISTS.getCode(), ResponseCode.USERNAME_EXISTS.getMsg());
        }

        //注册
        Integer result = userMapper.insert(user);
        if (result == 0) {
            //注册失败
            return ServerResponse.createServerResponseByFail(ResponseCode.REGISTER_FAIL.getCode(), ResponseCode.REGISTER_FAIL.getMsg());
        }
        return ServerResponse.createServerResponseBySucess();
    }
}
