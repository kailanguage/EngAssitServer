package com.kailang.engasst.service.impl;

import com.kailang.engasst.common.ResponseCode;
import com.kailang.engasst.dao.SentenceMapper;
import com.kailang.engasst.pojo.Sentence;
import com.kailang.engasst.service.ISentenceService;
import com.kailang.engasst.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SentenceService implements ISentenceService {

    @Autowired
    SentenceMapper sentenceMapper;
    @Override
    public ServerResponse add(Sentence sentence) {
        int count=sentenceMapper.insert(sentence);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.INSERT_FAIL.getCode(),ResponseCode.INSERT_FAIL.getMsg());
        return ServerResponse.createServerResponseBySucess();
    }

    @Override
    public ServerResponse delete(Integer userNo,Integer sno) {
        int count=sentenceMapper.deleteByPrimaryKey(userNo, sno);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.DELETE_FAIL.getCode(),ResponseCode.DELETE_FAIL.getMsg());
        return ServerResponse.createServerResponseBySucess();
    }

    @Override
    public ServerResponse update(Sentence sentence) {
        int count=sentenceMapper.updateByPrimaryKey(sentence);
        if(count==0)
            return ServerResponse.createServerResponseByFail(ResponseCode.UPDATE_FAIL.getCode(),ResponseCode.UPDATE_FAIL.getMsg());
        return ServerResponse.createServerResponseBySucess();
    }

    @Override
    public ServerResponse selectAll(Integer userNo) {
        List<Sentence> sentences=sentenceMapper.selectAll(userNo);
        if(!sentences.isEmpty())
            return ServerResponse.createServerResponseBySucess(sentences);
        if(sentences.isEmpty())
            return ServerResponse.createServerResponseByFail(ResponseCode.NO_DATA.getCode(),ResponseCode.NO_DATA.getMsg());
        return ServerResponse.createServerResponseByFail(ResponseCode.SELECT_FAIL.getCode(),ResponseCode.SELECT_FAIL.getMsg());
    }
}
