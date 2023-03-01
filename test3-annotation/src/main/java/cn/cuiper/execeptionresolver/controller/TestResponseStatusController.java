package cn.cuiper.execeptionresolver.controller;

import cn.cuiper.execeptionresolver.config.MyUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testResponseStatus")
public class TestResponseStatusController {

    @GetMapping("/getInfo")
    public String getInfo() throws MyUnauthorizedException {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new MyUnauthorizedException();
        }
        return "success";
    }

    @GetMapping("/getInfo2")
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "test @ResponseStatus method")
    // @ResponseStatus修饰方法时，修饰的方法会正常执行，但最终响应给客户端的响应码为@ResponseStatus中的响应码。
    public String getInfo2() {
        System.out.println("执行 getInfo2()");
        return "success";
    }
}
