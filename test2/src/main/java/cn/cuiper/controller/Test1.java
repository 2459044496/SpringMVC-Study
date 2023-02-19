package cn.cuiper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test1 {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
