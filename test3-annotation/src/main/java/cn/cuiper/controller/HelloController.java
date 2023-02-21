package cn.cuiper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("m1")
    /*
    * params可以限制请求参数
    * headers 限制请求头
    * method 请求方法类型 GET、POST、PUT
    * consumes 限制ContentType
    * produces 用来限制Accept
    *
    * 支持Ant风格的资源地址通配符
    *   ？ 匹配一个字符
    *   *   任意字符
    *   **  多层路径
    * */
    public ModelAndView m1() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "hello");
        mv.addObject("name", "cui");
        return mv;
    }

    @GetMapping("m2")
    public String m2(Model model) {
        model.addAttribute("name", "cui");
        return "hello";
    }

}
