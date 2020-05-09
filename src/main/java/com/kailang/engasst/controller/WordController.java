package com.kailang.engasst.controller;

import com.kailang.engasst.common.Const;
import com.kailang.engasst.common.ResponseCode;
import com.kailang.engasst.pojo.Word;
import com.kailang.engasst.service.IWordService;
import com.kailang.engasst.utils.ServerResponse;
import com.kailang.engasst.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class WordController {
    @Autowired
    IWordService wordService;

    @RequestMapping(value = "word/insert")
    public ServerResponse add(Word word,HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute(Const.CURRENT_USER);

        if(word==null){
            System.out.println(word==null||!word.getUserno().equals(userVO.getUserno()));

            return ServerResponse.createServerResponseByFail(ResponseCode.ILLEGAL_PARAM.getCode(),ResponseCode.ILLEGAL_PARAM.getMsg());
        }
        return wordService.add(word);
    }
    @RequestMapping(value = "word/select")
    public ServerResponse selectAll(HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute(Const.CURRENT_USER);
        return wordService.selectAll(userVO.getUserno());
    }

    @RequestMapping(value = "word/update")
    public ServerResponse update(Word word){
        return wordService.update(word);
    }

    @RequestMapping(value = "word/delete/{wno}")
    public ServerResponse delete(@PathVariable("wno") Integer wno,HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute(Const.CURRENT_USER);
        return wordService.delete(userVO.getUserno(), wno);
    }

}
