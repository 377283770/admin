package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//（服务间的通信Feign技术）和（监控断路器Hystrix熔断技术）
//使用feign技术的RESTful方式，请求service-producer服务
//feign也集成了ribbon，只要在微服务中依赖了ribbon，feign默认会使用ribbon定义的负载均衡策略
//Feign里已经集成了Hystrix熔断技术，所以不需要其他的jar包
//如果在系统里面集成了hystrix，就会马上把挂掉的这台服务提供方断路掉，让请求不再转发到这台机器上，大量减少调用失败。
//hystrix执行断路操作以后，并不表示这条路就永远断了，而是会一定时间间隔内缓慢尝试去请求这条路，如果能请求成功，断路就会恢复。
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//启用服务注册与发现
@EnableDiscoveryClient
//启用feign进行远程调用
@EnableFeignClients
public class ConsumerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerExampleApplication.class, args);
    }

}