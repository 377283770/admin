package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//服务间的通信
//使用ribbon技术的RESTful方式，请求service-producer服务
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//EnableEurekaClient表明为EurekaClient
@EnableEurekaClient
//EnableDiscoveryClient向服务中心注册发现
@EnableDiscoveryClient
public class RibbonConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }

    //LoadBalanced 注解表明restTemplate使用LoadBalancerClient执行请求
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

