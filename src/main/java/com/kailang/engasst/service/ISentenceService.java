package com.kailang.engasst.service;

import com.kailang.engasst.pojo.Sentence;
import com.kailang.engasst.utils.ServerResponse;

public interface ISentenceService {
    ServerResponse add(Sentence sentence);
    ServerResponse delete(Integer userNo, Integer sno);
    ServerResponse update(Sentence sentence);
    ServerResponse selectAll(Integer userNo);
}
