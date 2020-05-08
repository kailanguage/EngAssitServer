package com.kailang.engasst.service.impl;

import com.kailang.engasst.common.ResponseCode;
import com.kailang.engasst.dao.WordMapper;
import com.kailang.engasst.pojo.Word;
import com.kailang.engasst.service.IWordService;
import com.kailang.engasst.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class WordService implements IWordService {

    @Autowired
    WordMapper wordMapper;
    @Override
    public ServerResponse add(Word word) {
        int count=wordMapper.insert(word);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.INSERT_FAIL.getCode(),ResponseCode.INSERT_FAIL.getMsg());
        return ServerResponse.createServerResponseBySucess();
    }

    @Override
    public ServerResponse delete(Integer userNo,Integer wno) {
        int count=wordMapper.deleteByPrimaryKey(userNo,wno);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.DELETE_FAIL.getCode(),ResponseCode.DELETE_FAIL.getMsg());
        return ServerResponse.createServerResponseBySucess();
    }

    @Override
    public ServerResponse update(Word word) {
        int count=wordMapper.updateByPrimaryKey(word);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.UPDATE_FAIL.getCode(),ResponseCode.UPDATE_FAIL.getMsg());
        return ServerResponse.createServerResponseBySucess();
    }

    @Override
    public ServerResponse selectAll(Integer userNo) {
        List<Word> words=wordMapper.selectAll(userNo);
        if(!words.isEmpty())
            return ServerResponse.createServerResponseBySucess(words);
        if(words.isEmpty())
            return ServerResponse.createServerResponseByFail(ResponseCode.NO_DATA.getCode(),ResponseCode.NO_DATA.getMsg());
        return ServerResponse.createServerResponseByFail(ResponseCode.SELECT_FAIL.getCode(),ResponseCode.SELECT_FAIL.getMsg());
    }
}
