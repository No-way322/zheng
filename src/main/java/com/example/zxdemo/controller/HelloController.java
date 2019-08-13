package com.example.zxdemo.controller;

import com.example.zxdemo.bean.Gril;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Gril gril;

    @Value("${cupSize}")
    private String cupSize;

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "hello springboot";
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String info(){
        return "亲爱的"+name+"同学，"+"你的年纪虽然只有"+age+"岁，"+"但是你的却有"+cupSize;
    }

    @RequestMapping(value = "/lin",method = RequestMethod.GET)
    public String lin(){
        return gril.getName();
    }
}
