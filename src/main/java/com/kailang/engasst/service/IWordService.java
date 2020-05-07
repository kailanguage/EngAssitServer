package com.kailang.engasst.service;

import com.kailang.engasst.pojo.Word;
import com.kailang.engasst.utils.ServerResponse;

public interface IWordService {

    ServerResponse add(Word word);
    ServerResponse delete(Integer userNo, Integer wno);
    ServerResponse update(Word word);
    ServerResponse selectAll(Integer userNo);
}
