package cn.cuiper.execeptionresolver.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String errorMsg;
        if (e instanceof MyException) {
            errorMsg = "my自定义异常MyException";
        } else {
            errorMsg = "系统异常";
        }
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorMsg", errorMsg);
        return mv;
    }
}
