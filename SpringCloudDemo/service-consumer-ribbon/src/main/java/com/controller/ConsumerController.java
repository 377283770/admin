package com.controller;

import com.service.RibbonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    RibbonServiceImpl ribbonServiceImpl;

    //可以使用http://localhost:8081/hello/xiaowang请求
    @GetMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return ribbonServiceImpl.hello(name);
    }

}

