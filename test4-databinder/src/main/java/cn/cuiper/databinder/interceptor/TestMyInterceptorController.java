package cn.cuiper.databinder.interceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testMyInterceptorController")
public class TestMyInterceptorController {

    @RequestMapping("/test")
    public String test() {
        System.out.println("执行controller方法");
        return "success";
    }
}
