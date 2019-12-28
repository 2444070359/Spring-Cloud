package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
                                /*第二步开启熔断功能 的注解*/
/*@EnableCircuitBreaker//开启断路功能
@EnableDiscoveryClient//客户端
@SpringBootApplication*/

@EnableFeignClients // 开启Feign功能
@SpringCloudApplication//三合一注解
public class customerApplication {
                                  /*第三步 编写代码*/
   /* @Bean
    @LoadBalanced
    public RestTemplate getrestTemplate(){
        return  new RestTemplate();
    }*/
    public static void main(String[] args) {
        SpringApplication.run(customerApplication.class,args);
    }
}
