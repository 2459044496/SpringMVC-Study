package cn.cuiper.databinder.dataformat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/testFormatUserController")
public class TestFormatUserController {

    @RequestMapping("/test")
    public String test(@RequestBody FormatUser user) {
        return user.toString();
    }

    @GetMapping("/getUser")
    public FormatUser getUser() {
        FormatUser user = new FormatUser();
        user.setBirthday(new Date());
        return user;
    }
}
