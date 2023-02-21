package cn.cuiper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestParamController {

    @RequestMapping("teRequestParam")
    public ModelAndView teRequestParam(String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("teRequestParam");
        mv.addObject("name", name);
        mv.addObject("age", age);
        return mv;
    }

}
