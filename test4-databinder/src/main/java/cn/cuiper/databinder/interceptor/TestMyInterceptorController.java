package cn.cuiper.databinder.interceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testMyInterceptorController")
public class TestMyInterceptorController {

    @RequestMapping("/test")
    public String test() {
        // controller方法正常执行时拦截器

        // 1,执行preHandle
        // 2,执行test方法
        // 3,执行postHandle
        // 4,执行afterCompletion
        System.out.println("执行test方法");
        return "success";
    }

    @RequestMapping("/test2")
    public String test2() {
        // controller方法异常执行时拦截器

        // 1,执行preHandle
        // 2,执行test2方法
        // 3,执行afterCompletion

        System.out.println("执行test2方法");
        int i = 1 / 0;
        return "success";
    }
}
