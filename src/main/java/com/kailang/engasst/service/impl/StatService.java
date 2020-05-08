package com.kailang.engasst.service.impl;

import com.kailang.engasst.common.ResponseCode;
import com.kailang.engasst.dao.StatMapper;
import com.kailang.engasst.pojo.Stat;
import com.kailang.engasst.service.IStatService;
import com.kailang.engasst.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class StatService implements IStatService {

    @Autowired
    StatMapper statMapper;

    @Override
    public ServerResponse select(Integer userNo) {
        Stat stat = statMapper.selectByPrimaryKey(userNo);
        if (stat != null)
            return ServerResponse.createServerResponseBySucess(statMapper.selectByPrimaryKey(userNo));
        return ServerResponse.createServerResponseByFail(ResponseCode.SELECT_FAIL.getCode(), ResponseCode.SELECT_FAIL.getMsg());
    }

    @Override
    public ServerResponse update(Stat stat) {
        if (statMapper.updateByPrimaryKey(stat) != 0)
            return ServerResponse.createServerResponseBySucess();
        return ServerResponse.createServerResponseByFail(ResponseCode.UPDATE_FAIL.getCode(), ResponseCode.UPDATE_FAIL.getMsg());
    }
}
