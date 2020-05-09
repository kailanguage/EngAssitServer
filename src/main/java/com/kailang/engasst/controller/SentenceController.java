package com.kailang.engasst.controller;

import com.kailang.engasst.common.Const;
import com.kailang.engasst.common.ResponseCode;
import com.kailang.engasst.pojo.Sentence;
import com.kailang.engasst.service.ISentenceService;
import com.kailang.engasst.utils.ServerResponse;
import com.kailang.engasst.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SentenceController {

    @Autowired
    ISentenceService sentenceService;

    @RequestMapping(value = "sentence/insert")
    public ServerResponse add(Sentence sentence, HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute(Const.CURRENT_USER);
        if(sentence==null||sentence.getUserno()!=userVO.getUserno()){
            return ServerResponse.createServerResponseByFail(ResponseCode.ILLEGAL_PARAM.getCode(),ResponseCode.ILLEGAL_PARAM.getMsg());
        }
        return sentenceService.add(sentence);
    }
    @RequestMapping(value = "sentence/select")
    public ServerResponse selectAll(HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute(Const.CURRENT_USER);
        return sentenceService.selectAll(userVO.getUserno());
    }

    @RequestMapping(value = "sentence/update")
    public ServerResponse update(Sentence sentence){
        return sentenceService.update(sentence);
    }

    @RequestMapping(value = "sentence/delete/{wno}")
    public ServerResponse delete(@PathVariable("wno") Integer wno, HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute(Const.CURRENT_USER);
        return sentenceService.delete(userVO.getUserno(), wno);
    }
}
