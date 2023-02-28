package cn.cuiper.controller.returntype;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/returnMsgController")
public class ReturnMsgController {

    @RequestMapping("/simpleString")
    /*
    * 1，返回普通字符串
    *
    * 视图解析器配置的前缀为/WEB-INF/jsp/、后缀为.jsp。
    * 最终请求的地址为：/WEB-INF/jsp/default.jsp
    * */
    public String testString(Model model) {
        model.addAttribute("k", "v");
        return "default";
    }


    @RequestMapping("/forward")
    /*
    * 返回带有 forward 关键字的字符串
    * 使用forward关键字进行转发，不再经过视图解析器，需要编写完整的路径
    * */
    public String testForward() {

        // 转发的请求地址
        //return "forward:/returnMsgController/simpleString";

        // 转发到指定页面
        return "forward:/WEB-INF/jsp/hello.jsp";
    }

    @RequestMapping("/redirect")
    /*
    * 使用redirect关键字进行重定向，不再经过视图解析器，需要编写完整路径。
    * 使用原生servlet进行重定向时，路径需要带有项目名称。使用redirect关键字进行重定向时，不需要再加项目名称。
    * 重定向不能获取/WEB-INF/下的文件。
    * */
    public String testRedirect() {
        return "redirect:/login.jsp";
    }

}
