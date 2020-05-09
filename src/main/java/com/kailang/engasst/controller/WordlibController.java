package com.kailang.engasst.controller;

import com.kailang.engasst.service.IWordlibService;
import com.kailang.engasst.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordlibController {

    @Autowired
    IWordlibService wordlibService;

    @RequestMapping("wordlib/select/{level}")
    public ServerResponse selectByLevel(@PathVariable("level") short level){
        return wordlibService.selectByLevel(level);
    }

    @RequestMapping("wordlib/select/all")
    public ServerResponse selectAll(){
        return wordlibService.selectAll();
    }
}
