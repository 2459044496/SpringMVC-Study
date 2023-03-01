package cn.cuiper.execeptionresolver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testMyHandlerExceptionResolverController")
public class TestMyHandlerExceptionResolverController {

    @RequestMapping("/test")
    public String test() throws MyException {
        throw new MyException();
    }

}
