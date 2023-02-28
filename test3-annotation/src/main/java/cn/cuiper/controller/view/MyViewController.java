package cn.cuiper.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myViewController")
public class MyViewController {

    @RequestMapping("/myView")
    public String myView() {
        // 返回MyView(View接口子类)类，不是jsp或者html等
        return "myView";
    }
}
