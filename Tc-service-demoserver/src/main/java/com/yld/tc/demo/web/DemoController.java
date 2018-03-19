package com.yld.tc.demo.web;


import com.teamcenter.hello.Hello;
import com.teamcenter.user.IUserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableHystrix
@CrossOrigin
public class DemoController {

    @Autowired
    public Hello helloService;

    @Autowired
    public IUserManagement userService;


    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String hi() {
        return helloService.test();
    }


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public void hello() {
        userService.mutliCretionUsers();
    }


}
