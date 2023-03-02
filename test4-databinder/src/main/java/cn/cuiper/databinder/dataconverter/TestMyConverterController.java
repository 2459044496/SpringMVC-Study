package cn.cuiper.databinder.dataconverter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testMyConverterController")
public class TestMyConverterController {

    @RequestMapping("/test")
    public Integer test(@RequestParam("s") Integer s) {
        return s;
    }
}
