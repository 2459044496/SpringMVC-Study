package cn.cuiper.controller.returntype;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/returnVoidController")
public class ReturnVoidController {

    @RequestMapping("/testVoid")
    /*
    * 如果控制器的方法返回void，默认会跳转路径：视图解析器前缀 + 请求地址 + 视图解析器后缀。
    * 本例：
    *   视图解析器前缀为/WEB-INF/jsp/，视图解析器后缀为.jsp；
    *   请求地址为/returnVoid/testVoid；
    *   则默认跳转的地址为：/WEB-INF/jsp/returnVoidController/testVoid.jsp
    * */
    public void testVoidMethod() {
    }


    @RequestMapping("/testServletForward")
    /*
    * 原生servlet转发
    * request.getRequestDispatcher("资源路径").forward(request,response)
    * 此时视图解析器将不再起作用，不会再自动拼接视图解析器的前缀和后缀。
    *
    * 转发可以访问到/WEB-INF/pages下的文件,浏览器地址不变。
    * */
    public void testServletForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/returnVoidController/testServletForward.jsp")
                .forward(request, response);
    }

    /*
    * 原生servlet重定向
    * response.sendRedirect(项目路径 + 资源路径)
    * 重定向不能访问/WEB-INF/pages下的文件,浏览器地址改变。
    * */
    @RequestMapping("/testServletRedirect")
    public void testServletRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("获取项目路径:" + request.getContextPath());
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    @RequestMapping("/testPrintWriter")
    public void testPrintWriter(HttpServletResponse response) throws IOException {
        // 设置编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.println(true);
        writer.println("testPrintWriter");
    }

}
