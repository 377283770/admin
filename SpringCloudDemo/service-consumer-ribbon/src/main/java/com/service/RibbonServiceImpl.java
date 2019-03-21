package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonServiceImpl{

    @Autowired
    RestTemplate restTemplate;

    public String hello(String name) {
        //使用ribbon技术的RESTful方式，请求service-producer服务
        return restTemplate.getForObject("http://service-producer/hello?name="+name,String.class);
    }
}

