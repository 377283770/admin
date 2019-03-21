package com.service;

import com.hystrix.FeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//Feign里已经集成了Hystrix熔断技术，所以不需要其他的jar包
//service-producer服务里的hello方法如果出现堵塞或者服务宕机，就会执行FeignServiceHystrix里的hello来快速回应，保证服务不堵塞
@FeignClient(value = "service-producer",fallback = FeignServiceHystrix.class)
public interface FeignExampleService {

    @GetMapping("hello")
    public String hello(@RequestParam(value = "name") String name);

}
