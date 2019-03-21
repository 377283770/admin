package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//Zuul能实现路由转发和过滤器的功能，同时还支持负载均衡，类似ngnix
@EnableEurekaClient
@EnableDiscoveryClient
//支持网关路由
@EnableZuulProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

}
