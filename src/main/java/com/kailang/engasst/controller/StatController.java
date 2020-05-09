package com.kailang.engasst.controller;

import com.kailang.engasst.common.Const;
import com.kailang.engasst.common.ResponseCode;
import com.kailang.engasst.pojo.Stat;
import com.kailang.engasst.service.IStatService;
import com.kailang.engasst.utils.ServerResponse;
import com.kailang.engasst.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class StatController {

    @Autowired
    IStatService statService;

    @RequestMapping("stat/select")
    public ServerResponse select(HttpSession session){
        UserVO userInfo=(UserVO)session.getAttribute(Const.CURRENT_USER);
        return statService.select(userInfo.getUserno());
    }

    @RequestMapping("stat/update")
    public ServerResponse update(Stat stat){
        return statService.update(stat);
    }
}
