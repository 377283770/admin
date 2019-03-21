package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//高可用配置中心动态刷新
//导入actuator包，bus-amqp包，并在config-server中也导入
//执行刷新操作 post请求http://localhost:****/actuator/bus-refresh
//bus-amqp消息总线集成了rabbitmq来监听config-server服务，只要执行上面的post请求，就会通知所有监听者执行更新操作，达到高可用动态刷新的目的
//@RefreshScope 会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//激活注册发现
@EnableDiscoveryClient
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
