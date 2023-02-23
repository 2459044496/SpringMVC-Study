package cn.cuiper.controller;

import cn.cuiper.pojo.Book;
import cn.cuiper.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@Controller
public class TestServletApiController {

    @RequestMapping("teHttpServletRe")
    // HandlerMethodArgumentResolver接口的实现类会解析ServletAPI类型的参数
    public String teHttpServletRe(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getSession());
        System.out.println(response.toString());
        return "default";
    }

    @RequestMapping("teWriter")
    public void teWriter(Writer out) throws IOException {
        // 输出到页面
        out.write("This is teWriter.");
    }

}
