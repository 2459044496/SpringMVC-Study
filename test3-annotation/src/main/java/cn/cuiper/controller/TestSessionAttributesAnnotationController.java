package cn.cuiper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/testSessionAttributesAnnotationController")
@SessionAttributes(names = {"k1", "k2"}, types = {String.class, Integer.class})
// @SessionAttributes注解作用范围为TYPE，不能在方法上使用
// 在不使用@SessionAttributes注解时，Model中的键值是request级的，在类上使用后符合规则的键值会变成session级别
// 取names和types属性的并集，names为key，types为value类型
public class TestSessionAttributesAnnotationController {

    @RequestMapping(params="method=index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index.jsp");
        mav.addObject("attr1", "attr1Value");
        mav.addObject("attr2", "attr2Value");
        return mav;
    }

    @RequestMapping("/setSessionAttributes")
    // 配置SessionAttributes
    public ModelAndView setSessionAttributes(@RequestParam("k1")String k1) {
        ModelAndView mv = new ModelAndView("default");
        mv.addObject("k1", k1);
        System.out.println("setSessionAttributes设置 k1值为:" + k1);
        return mv;
    }

    @RequestMapping("/useSessionAttributes")
    // 使用SessionAttributes
    public String useSessionAttributes(@ModelAttribute("k1")String k1) {
        System.out.println("useSessionAttributes获取 k1值为:" + k1);
        return "default";
    }

    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus sessionStatus) {
        System.out.println("获取sessionStatus状态为" + sessionStatus.isComplete());
        sessionStatus.setComplete();
        return "default";
    }
}
