package cn.cuiper.execeptionresolver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testSimpleMappingExceptionResolverController")
public class TestSimpleMappingExceptionResolverController {

    @GetMapping("/getInfo")
    public String getInfo() {
        int[] arr = new int[2];
        System.out.println(arr[3]);
        return "success";
    }
}
