package com.kailang.engasst.service.impl;

import com.kailang.engasst.common.ResponseCode;
import com.kailang.engasst.dao.WordlibMapper;
import com.kailang.engasst.pojo.Wordlib;
import com.kailang.engasst.service.IWordlibService;
import com.kailang.engasst.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class WordlibService implements IWordlibService {

    @Autowired
    WordlibMapper wordlibMapper;

    @Override
    public ServerResponse selectByLevel(Short level) {
        List<Wordlib> wordlibs=wordlibMapper.selectByLevel(level);
        if(!wordlibs.isEmpty())
            return ServerResponse.createServerResponseBySucess(wordlibs);
        if(wordlibs.isEmpty())
            return ServerResponse.createServerResponseByFail(ResponseCode.NO_DATA.getCode(),ResponseCode.NO_DATA.getMsg());
        return ServerResponse.createServerResponseByFail(ResponseCode.SELECT_FAIL.getCode(),ResponseCode.SELECT_FAIL.getMsg());

    }

    @Override
    public ServerResponse selectAll() {
        List<Wordlib> wordlibs=wordlibMapper.selectAll();
        if(!wordlibs.isEmpty())
            return ServerResponse.createServerResponseBySucess(wordlibs);
        if(wordlibs.isEmpty())
            return ServerResponse.createServerResponseByFail(ResponseCode.NO_DATA.getCode(),ResponseCode.NO_DATA.getMsg());
        return ServerResponse.createServerResponseByFail(ResponseCode.SELECT_FAIL.getCode(),ResponseCode.SELECT_FAIL.getMsg());
    }
}
