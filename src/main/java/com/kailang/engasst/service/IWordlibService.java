package com.kailang.engasst.service;

import com.kailang.engasst.pojo.Wordlib;
import com.kailang.engasst.utils.ServerResponse;

public interface IWordlibService {
    ServerResponse selectByLevel(Short level);
    ServerResponse selectAll();
}
