package com.hystrix;

import com.service.FeignExampleService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class FeignServiceHystrix implements FeignExampleService {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "对不起，请求的服务已暂停！";
    }
}
