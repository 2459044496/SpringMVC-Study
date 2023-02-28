package cn.cuiper.controller.returntype;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/returnModelAndViewController")
public class ReturnModelAndViewController {

    @RequestMapping("/testModelAndView")
    /*
    * ModelAndView对象是Spring提供的一个对象，可以用来调整具体的jsp视图，为该对象添加模型数据。
    * 控制器处理方法的返回值如果为ModelAndView，则其既包含视图信息，也包含模型数据信息。
    *
    * */
    public ModelAndView testModelAndViewMethod() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("returnVoidController/testModelAndView");
        mv.addObject("name", "cui");
        mv.addObject("remark", "备注");
        return mv;
    }

}
