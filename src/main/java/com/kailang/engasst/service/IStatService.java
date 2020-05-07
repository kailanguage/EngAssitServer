package com.kailang.engasst.service;

import com.kailang.engasst.pojo.Stat;
import com.kailang.engasst.utils.ServerResponse;

public interface IStatService {
    ServerResponse select(Integer userNo);
    ServerResponse update(Stat stat);
}
