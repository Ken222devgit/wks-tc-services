package com.yld.tc.demo;

import com.teamcenter.hello.Hello;
import com.teamcenter.user.IUserManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoServerApplicationBootstrap {


    public static void main(String[] args) {
        SpringApplication.run(DemoServerApplicationBootstrap.class, args);
    }


    @Bean
    @LoadBalanced
    Hello hello() {
        return new Hello();
    }


    @Bean
    @LoadBalanced
    IUserManagement user() {
        return new IUserManagement();
    }

//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//        JettyEmbeddedServletContainerFactory factory =
//                new JettyEmbeddedServletContainerFactory();
//        return factory;
//    }

}
