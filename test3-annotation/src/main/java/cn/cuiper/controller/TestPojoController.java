package cn.cuiper.controller;

import cn.cuiper.pojo.Book;
import cn.cuiper.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestPojoController {

    @RequestMapping("tePojoParam")
    // 引用类型参数绑定
    // SpringMVC会按请求参数名和POJO属性名进行自动匹配，自动为该对象填充属性值
    public ModelAndView tePojoParam(User user) {
        System.out.println("传入的user对象:" + user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tePojoParam");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("teBook")
    // 测试复合数据类型
    public ModelAndView teBook(Book book) {
        System.out.println(book);
        ModelAndView mv = new ModelAndView("default");
        return mv;
    }

}
