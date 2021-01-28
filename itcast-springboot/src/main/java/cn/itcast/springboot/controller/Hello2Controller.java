package cn.itcast.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjiahao
 * @date 2021/1/22 15:38
 */
@RestController
@RequestMapping("hello2")
public class Hello2Controller {

    @GetMapping("show2")
    public String test(){
        return "hello world2";
    }
}
